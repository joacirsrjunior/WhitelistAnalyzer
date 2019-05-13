package br.com.joacirjunior.whitelist.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.json.JSONException;
import org.json.JSONObject;


@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = ValidationResponse.class)
public class ValidationResponse {

    private Boolean match;
    private String regex;
    private Integer correlationId;

    public ValidationResponse(){
    }

    public ValidationResponse(Boolean match, String regex, Integer correlationId) {
        this.match = match;
        this.regex = regex;
        this.correlationId = correlationId;
    }

    public Boolean getMatch() {
        return match;
    }

    public void setMatch(Boolean match) {
        this.match = match;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
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

            jsonInfo.put("match", this.match);
            jsonInfo.put("regex", this.regex);
            jsonInfo.put("correlationId", this.correlationId);

        } catch (JSONException e1) {
        }

        return jsonInfo.toString();
    }

}
