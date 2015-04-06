
package liffft.com.stackrx.services.questions.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Item {

    @Expose
    private List<String> tags = new ArrayList<String>();
    @Expose
    private Owner owner;
    @SerializedName("is_answered")
    @Expose
    private Boolean isAnswered;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("answer_count")
    @Expose
    private Integer answerCount;
    @Expose
    private Integer score;
    @SerializedName("last_activity_date")
    @Expose
    private Integer lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("last_edit_date")
    @Expose
    private Integer lastEditDate;
    @SerializedName("question_id")
    @Expose
    private Integer questionId;
    @Expose
    private String link;
    @Expose
    private String title;
    @SerializedName("accepted_answer_id")
    @Expose
    private Integer acceptedAnswerId;
    @SerializedName("bounty_amount")
    @Expose
    private Integer bountyAmount;
    @SerializedName("bounty_closes_date")
    @Expose
    private Integer bountyClosesDate;
    @SerializedName("closed_date")
    @Expose
    private Integer closedDate;
    @SerializedName("closed_reason")
    @Expose
    private String closedReason;
    @SerializedName("protected_date")
    @Expose
    private Integer protectedDate;
    @SerializedName("community_owned_date")
    @Expose
    private Integer communityOwnedDate;

    /**
     * 
     * @return
     *     The tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

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
     *     The isAnswered
     */
    public Boolean getIsAnswered() {
        return isAnswered;
    }

    /**
     * 
     * @param isAnswered
     *     The is_answered
     */
    public void setIsAnswered(Boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    /**
     * 
     * @return
     *     The viewCount
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * 
     * @param viewCount
     *     The view_count
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * 
     * @return
     *     The answerCount
     */
    public Integer getAnswerCount() {
        return answerCount;
    }

    /**
     * 
     * @param answerCount
     *     The answer_count
     */
    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
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
     *     The lastEditDate
     */
    public Integer getLastEditDate() {
        return lastEditDate;
    }

    /**
     * 
     * @param lastEditDate
     *     The last_edit_date
     */
    public void setLastEditDate(Integer lastEditDate) {
        this.lastEditDate = lastEditDate;
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
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The acceptedAnswerId
     */
    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    /**
     * 
     * @param acceptedAnswerId
     *     The accepted_answer_id
     */
    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    /**
     * 
     * @return
     *     The bountyAmount
     */
    public Integer getBountyAmount() {
        return bountyAmount;
    }

    /**
     * 
     * @param bountyAmount
     *     The bounty_amount
     */
    public void setBountyAmount(Integer bountyAmount) {
        this.bountyAmount = bountyAmount;
    }

    /**
     * 
     * @return
     *     The bountyClosesDate
     */
    public Integer getBountyClosesDate() {
        return bountyClosesDate;
    }

    /**
     * 
     * @param bountyClosesDate
     *     The bounty_closes_date
     */
    public void setBountyClosesDate(Integer bountyClosesDate) {
        this.bountyClosesDate = bountyClosesDate;
    }

    /**
     * 
     * @return
     *     The closedDate
     */
    public Integer getClosedDate() {
        return closedDate;
    }

    /**
     * 
     * @param closedDate
     *     The closed_date
     */
    public void setClosedDate(Integer closedDate) {
        this.closedDate = closedDate;
    }

    /**
     * 
     * @return
     *     The closedReason
     */
    public String getClosedReason() {
        return closedReason;
    }

    /**
     * 
     * @param closedReason
     *     The closed_reason
     */
    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
    }

    /**
     * 
     * @return
     *     The protectedDate
     */
    public Integer getProtectedDate() {
        return protectedDate;
    }

    /**
     * 
     * @param protectedDate
     *     The protected_date
     */
    public void setProtectedDate(Integer protectedDate) {
        this.protectedDate = protectedDate;
    }

    /**
     * 
     * @return
     *     The communityOwnedDate
     */
    public Integer getCommunityOwnedDate() {
        return communityOwnedDate;
    }

    /**
     * 
     * @param communityOwnedDate
     *     The community_owned_date
     */
    public void setCommunityOwnedDate(Integer communityOwnedDate) {
        this.communityOwnedDate = communityOwnedDate;
    }

}
