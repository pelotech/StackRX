
package liffft.com.stackrx.services.answers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Item {

    @Expose
    private Owner owner;
    @SerializedName("is_accepted")
    @Expose
    private Boolean isAccepted;
    @Expose
    private Integer score;
    @SerializedName("last_activity_date")
    @Expose
    private Integer lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("answer_id")
    @Expose
    private Integer answerId;
    @SerializedName("question_id")
    @Expose
    private Integer questionId;
    @Expose
    private String body;

    /**
     * 
     * @return
     *     The owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * 
     * @param owner
     *     The owner
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * 
     * @return
     *     The isAccepted
     */
    public Boolean getIsAccepted() {
        return isAccepted;
    }

    /**
     * 
     * @param isAccepted
     *     The is_accepted
     */
    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    /**
     * 
     * @return
     *     The score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 
     * @return
     *     The lastActivityDate
     */
    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    /**
     * 
     * @param lastActivityDate
     *     The last_activity_date
     */
    public void setLastActivityDate(Integer lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    /**
     * 
     * @return
     *     The creationDate
     */
    public Integer getCreationDate() {
        return creationDate;
    }

    /**
     * 
     * @param creationDate
     *     The creation_date
     */
    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 
     * @return
     *     The answerId
     */
    public Integer getAnswerId() {
        return answerId;
    }

    /**
     * 
     * @param answerId
     *     The answer_id
     */
    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    /**
     * 
     * @return
     *     The questionId
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 
     * @param questionId
     *     The question_id
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 
     * @return
     *     The body
     */
    public String getBody() {
        return body;
    }

    /**
     * 
     * @param body
     *     The body
     */
    public void setBody(String body) {
        this.body = body;
    }

}
