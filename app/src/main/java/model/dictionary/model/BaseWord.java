package model.dictionary.model;

public class BaseWord {
    private final String mRawData;
    private final NatureLanguageType mNatureType;

    BaseWord(String rawData, NatureLanguageType natureType) {
        mRawData = rawData;
        mNatureType = natureType;
    }

    public String getRawData() {
        return mRawData;
    }

    public NatureLanguageType getNatureType() {
        return mNatureType;
    }
}
