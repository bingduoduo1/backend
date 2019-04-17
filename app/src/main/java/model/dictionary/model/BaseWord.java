package model.dictionary.model;

public abstract class BaseWord {
    protected final String mRawData;
    protected final NatureLanguageType mNatureType;

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


    @Override
    public boolean equals(Object obj){

        if(null == obj)return false;
        BaseWord word = (BaseWord)obj;
        if((this.mRawData).equals(word.getRawData())  &&
            this.mNatureType == word.getNatureType())
            return true;
        return false;


    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash +  mNatureType.hashCode();
        hash = 31 * hash + (mRawData== null ? 0 : mRawData.hashCode());
        return hash;

    }
}
