package model.dictionary.model;

public abstract class BaseWord {
    private final String mRawData;
    private final NatureLanguageType mNatureType;

    public BaseWord(String rawData, NatureLanguageType natureType) {
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
