package dictionary.model;

import dictionary.exception.DictionaryException;
import dictionary.exception.NotMatchActionTypeExpection;

import static dictionary.helper.InputActionHelper.inputActionContentCheck;

public class InputAction extends BaseAction {
    private String mContent;

    public InputAction(ActionType actionType, ExecutePlaceType executePlace, String content) throws DictionaryException {
        super(actionType, executePlace);
        if (actionType != ActionType.INPUT) {
            throw new NotMatchActionTypeExpection();
        }
        if (!inputActionContentCheck(content)) {
            throw new DictionaryException("invalid input action content\n");
        }
        mContent = content;
    }

    public String getContent() {
        return mContent;
    }
}
