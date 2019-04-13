package com.iflytek.voicedemo;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.GrammarListener;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.LexiconListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.speech.util.JsonParser;

import model.dictionary.application.GlobalDictionary;
import model.dictionary.application.LookUpInterface;
import model.dictionary.exception.DictionaryException;

import static android.content.Context.MODE_PRIVATE;


public class SpeechRecognitionIflytek implements SpeechRecognitionInterface{
    private static final String LOG_TAG = SpeechRecognitionIflytek.class.getSimpleName();

    private static final String KEY_GRAMMAR_ABNF_ID = "grammar_abnf_id";
    private static final String GRAMMAR_TYPE_ABNF = "abnf";
    private static final String GRAMMAR_TYPE_BNF = "bnf";
    private static final String mCloud = "cloud";
    private final String mEngineType = SpeechConstant.TYPE_CLOUD;

    private SpeechRecognizer mRecognizer;
    private SharedPreferences mSharedPreferences;
    private String mCLoudGrammar = null;
    private Activity mCallerActivity;
    private String mGrammarPath;
    private String mParserResult;
    private LookUpInterface mLookUpHandle;


    public SpeechRecognitionIflytek(Activity callerActivity, String grammarPath){
        mCallerActivity = callerActivity;
        mGrammarPath = grammarPath;
        mParserResult = "";
        mLookUpHandle = GlobalDictionary.createDictionary();
        this.initSpeechRecognizer();
        this.SetParam();
    }

    private void initSpeechRecognizer() {
        mRecognizer = SpeechRecognizer.createRecognizer(mCallerActivity, mInitListener);
        mCLoudGrammar = com.iflytek.speech.util.FucUtil.readFile(mCallerActivity, mGrammarPath,"utf-8");

        mSharedPreferences = mCallerActivity.getSharedPreferences(mCallerActivity.getPackageName(),	MODE_PRIVATE);
    }

    private InitListener mInitListener = new InitListener(){
        @Override
        public void onInit(int code) {
            String info;
            if (code != ErrorCode.SUCCESS) {
                info = "init fail, error code: "+code;
                //TODO
            } else {
                info = "init success";
            }
            Log.d(LOG_TAG, info);
        }
    };

    private LexiconListener mLexiconListener = new LexiconListener() {
        @Override
        public void onLexiconUpdated(String lexiconId, SpeechError speechError) {
            String info;
            if (speechError != null) {
                info = "lexicon update fail, error code: "+speechError.getErrorCode();
                //TODO
            } else {
                info = "lexicon update success";
            }
            Log.d(LOG_TAG, info);
        }
    };

    private GrammarListener mCloudGrammarListener = new GrammarListener() {
        @Override
        public void onBuildFinish(String grammarId, SpeechError speechError) {
            String info;
            if (speechError != null) {
                info = "grammar build fail, error code: "+speechError.getErrorCode();
            } else {
                info = "grammar build success: (grammar ID)" + grammarId;
            }
            Log.d(LOG_TAG, info);
        }
    };

    private RecognizerListener mRecognizerListener = new RecognizerListener() {
        @Override
        public void onVolumeChanged(int volume, byte[] data) {
            String info = "Talking...(volume: " + volume + ", data length: " + data.length + ")";
            Log.d(LOG_TAG, info);
        }

        @Override
        public void onBeginOfSpeech() {

        }

        @Override
        public void onEndOfSpeech() {

        }

        @Override
        public void onResult(RecognizerResult recognizerResult, boolean islast) {
            if (null != recognizerResult) {
                String origin_result = recognizerResult.getResultString();
                Log.d(LOG_TAG, "origin recognizer result: " + origin_result);
                String parser_result;
                if (mCloud.equalsIgnoreCase(mEngineType)) {
                    parser_result = JsonParser.parseGrammarResult(origin_result);
                } else {
                    parser_result = JsonParser.parseLocalGrammarResult(origin_result);
                }
                Log.d(LOG_TAG, "parser result: "+parser_result);
                mParserResult += parser_result;
            } else {
                Log.d(LOG_TAG, "recognizer result is null");
            }
        }

        @Override
        public void onError(SpeechError speechError) {
            if (speechError != null) {
                String info = "recognize fail, error code: "+speechError.getErrorCode();
                Log.d(LOG_TAG, info);
            }
        }

        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {

        }
    };

    private boolean buildGrammar() {
        int ret;
        ret = mRecognizer.buildGrammar(GRAMMAR_TYPE_ABNF, mCLoudGrammar, mCloudGrammarListener);
        String info;
        if (ret != ErrorCode.SUCCESS) {
            info = "grammar build procedure fail, error code: " + ret;
        } else {
            info = "grammar build procedure success";
        }
        Log.d(LOG_TAG, info);
        return ret == ErrorCode.SUCCESS;
    }

    private boolean SetParam() {
        boolean ret;
        mRecognizer.setParameter(SpeechConstant.ENGINE_TYPE, mEngineType);
        mRecognizer.setParameter(SpeechConstant.RESULT_TYPE, "json");
        mRecognizer.setParameter(SpeechConstant.TEXT_ENCODING, "utf-8");
        ret = this.buildGrammar();
        if (!ret)
            return ret;

        if (mCloud.equalsIgnoreCase(mEngineType)) {
            String grammarId = mSharedPreferences.getString(KEY_GRAMMAR_ABNF_ID, null);
            if (TextUtils.isEmpty(grammarId)) {
                ret = false;
            } else {
                mRecognizer.setParameter(SpeechConstant.CLOUD_GRAMMAR, grammarId);
                ret = true;
            }
        }

        final String audio_path = "/msc/asr.wav";
        mRecognizer.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mRecognizer.setParameter(SpeechConstant.ASR_AUDIO_PATH, Environment.getExternalStorageState() + audio_path);
        return ret;
    }

    public int startRecognize() {
        int ret;
        ret = mRecognizer.startListening(mRecognizerListener);
        String info;
        if (ret != ErrorCode.SUCCESS) {
            info = "recognize interface fail, error code: " + ret;
        } else {
            info = "recognize interface success";
        }
        Log.d(LOG_TAG, info);
        return ret;
    }

    public void stopRecognize() {
        mRecognizer.stopListening();
    }

    public void cancelRecognize() {
        mRecognizer.cancel();
    }

    public String getAction() {
        this.stopRecognize();
        Log.d(LOG_TAG, "total parser result" + mParserResult);
        String ret = "";
        try {
            mLookUpHandle.exactLookUpWord(mParserResult, ret);
        } catch (DictionaryException e){
            e.printStackTrace();
        }
        mParserResult = "";
        Log.d(LOG_TAG, "action result" + ret);
        return ret;
    }

    public void destroy() {
        if (null != mRecognizer) {
            mRecognizer.cancel();
            mRecognizer.destroy();
        }
    }
}
