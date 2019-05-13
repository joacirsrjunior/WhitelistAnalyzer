package br.com.joacirjunior.whitelist.model;

import br.com.joacirjunior.whitelist.enums.ECommandType;
import org.json.JSONException;
import org.json.JSONObject;


// @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = InsertCommand.class)
public class InsertCommand implements ICommand {

    private ECommandType commandType;
    private String client;
    private String regex;

    public InsertCommand(){
        this.commandType = ECommandType.INSERTION;
    }

    public InsertCommand(String client, String regex){
        this.commandType = ECommandType.INSERTION;
        this.client = client;
        this.regex = regex;
    }

    public ECommandType getCommandType(){
        return this.commandType;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String toString(){
        JSONObject jsonInfo = new JSONObject();

        try {

            if(this.client != null) {
                jsonInfo.put("client", this.client);
            }
            jsonInfo.put("regex", this.regex);

        } catch (JSONException e1) {
        }

        return jsonInfo.toString();
    }

}
