package model.dictionary.model;



public class CustomWord extends BaseWord {
    public CustomWord(String rawData, NatureLanguageType natureType) {
        super(rawData, natureType);
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
