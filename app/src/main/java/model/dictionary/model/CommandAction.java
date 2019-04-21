package model.dictionary.model;


import model.dictionary.exception.DictionaryException;
import model.dictionary.exception.NotMatchActionTypeExpection;

import static model.dictionary.helper.CommandActionHelper.commandActionContentCheck;
public class CommandAction extends BaseAction {
    private String mContent;

    public CommandAction(ActionType actionType, ExecutePlaceType executePlace, String content) throws DictionaryException {
        super(actionType, executePlace);
        if (actionType != ActionType.COMMAND) {
            throw new NotMatchActionTypeExpection();
        }
        if (!commandActionContentCheck(content)) {
            throw new DictionaryException("invalid input action content------------------\n");
        }
        mContent = content;
    }

    public String getContent() {
        return mContent;
    }
}
