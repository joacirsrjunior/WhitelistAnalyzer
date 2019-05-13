package br.com.joacirjunior.whitelist.model;

import br.com.joacirjunior.whitelist.enums.ECommandType;
import org.json.JSONException;
import org.json.JSONObject;


// @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="correlationId", scope = ValidationCommand.class)
public class ValidationCommand implements ICommand {

    private ECommandType commandType;
    private String client;
    private String url;
    private Integer correlationId;

    public ValidationCommand(){
        this.commandType = ECommandType.VALIDATION;
    }

    public ValidationCommand(String client, String url, Integer correlationId) {
        this.commandType = ECommandType.VALIDATION;
        this.client = client;
        this.url = url;
        this.correlationId = correlationId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(Integer correlationId) {
        this.correlationId = correlationId;
    }

    public String toString(){
        JSONObject jsonInfo = new JSONObject();

        try {

            jsonInfo.put("client", this.client);
            jsonInfo.put("url", this.url);
            jsonInfo.put("correlationId", this.correlationId);

        } catch (JSONException e1) {
        }

        return jsonInfo.toString();
    }

}
