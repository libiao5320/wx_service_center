/**
 *
 */
package com.royao.model;

import java.io.Serializable;

public class ApiResult implements Serializable {

    private static final long serialVersionUID = -6671900927701397763L;

    private boolean success = false;

    private String resultCode;

    private String description;

    private Object resultBody;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getResultBody() {
        return resultBody;
    }

    public void setResultBody(Object resultBody) {
        this.resultBody = resultBody;
    }
}
