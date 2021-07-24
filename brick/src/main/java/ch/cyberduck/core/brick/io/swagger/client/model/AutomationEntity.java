/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * List Automations
 */
@Schema(description = "List Automations")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-23T20:47:00.742522+02:00[Europe/Paris]")
public class AutomationEntity {
  @JsonProperty("id")
  private Integer id = null;

  /**
   * Automation type
   */
  public enum AutomationEnum {
    CREATE_FOLDER("create_folder"),
    REQUEST_FILE("request_file"),
    REQUEST_MOVE("request_move"),
    COPY_NEWEST_FILE("copy_newest_file"),
    DELETE_FILE("delete_file"),
    COPY_FILE("copy_file"),
    MOVE_FILE("move_file");

    private String value;

    AutomationEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static AutomationEnum fromValue(String text) {
      for (AutomationEnum b : AutomationEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("automation")
  private AutomationEnum automation = null;

  /**
   * How this automation is triggered to run. One of: &#x60;realtime&#x60;, &#x60;daily&#x60;, &#x60;custom_schedule&#x60;, &#x60;webhook&#x60;, &#x60;email&#x60;, or &#x60;action&#x60;.
   */
  public enum TriggerEnum {
    REALTIME("realtime"),
    DAILY("daily"),
    CUSTOM_SCHEDULE("custom_schedule"),
    WEBHOOK("webhook"),
    EMAIL("email"),
    ACTION("action");

    private String value;

    TriggerEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static TriggerEnum fromValue(String text) {
      for (TriggerEnum b : TriggerEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("trigger")
  private TriggerEnum trigger = null;

  @JsonProperty("interval")
  private String interval = null;

  @JsonProperty("next_process_on")
  private String nextProcessOn = null;

  @JsonProperty("schedule")
  private Object schedule = null;

  @JsonProperty("source")
  private String source = null;

  @JsonProperty("destinations")
  private String destinations = null;

  @JsonProperty("destination_replace_from")
  private String destinationReplaceFrom = null;

  @JsonProperty("destination_replace_to")
  private String destinationReplaceTo = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("user_id")
  private Integer userId = null;

  @JsonProperty("user_ids")
  private List<Integer> userIds = null;

  @JsonProperty("group_ids")
  private List<Integer> groupIds = null;

  @JsonProperty("webhook_url")
  private String webhookUrl = null;

  @JsonProperty("trigger_actions")
  private String triggerActions = null;

  @JsonProperty("trigger_action_path")
  private String triggerActionPath = null;

  @JsonProperty("value")
  private Object value = null;

  public AutomationEntity id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Automation ID
   * @return id
  **/
  @Schema(example = "1", description = "Automation ID")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AutomationEntity automation(AutomationEnum automation) {
    this.automation = automation;
    return this;
  }

   /**
   * Automation type
   * @return automation
  **/
  @Schema(example = "create_folder", description = "Automation type")
  public AutomationEnum getAutomation() {
    return automation;
  }

  public void setAutomation(AutomationEnum automation) {
    this.automation = automation;
  }

  public AutomationEntity trigger(TriggerEnum trigger) {
    this.trigger = trigger;
    return this;
  }

   /**
   * How this automation is triggered to run. One of: &#x60;realtime&#x60;, &#x60;daily&#x60;, &#x60;custom_schedule&#x60;, &#x60;webhook&#x60;, &#x60;email&#x60;, or &#x60;action&#x60;.
   * @return trigger
  **/
  @Schema(example = "realtime", description = "How this automation is triggered to run. One of: `realtime`, `daily`, `custom_schedule`, `webhook`, `email`, or `action`.")
  public TriggerEnum getTrigger() {
    return trigger;
  }

  public void setTrigger(TriggerEnum trigger) {
    this.trigger = trigger;
  }

  public AutomationEntity interval(String interval) {
    this.interval = interval;
    return this;
  }

   /**
   * If trigger is &#x60;daily&#x60;, this specifies how often to run this automation.  One of: &#x60;day&#x60;, &#x60;week&#x60;, &#x60;week_end&#x60;, &#x60;month&#x60;, &#x60;month_end&#x60;, &#x60;quarter&#x60;, &#x60;quarter_end&#x60;, &#x60;year&#x60;, &#x60;year_end&#x60;
   * @return interval
  **/
  @Schema(example = "week", description = "If trigger is `daily`, this specifies how often to run this automation.  One of: `day`, `week`, `week_end`, `month`, `month_end`, `quarter`, `quarter_end`, `year`, `year_end`")
  public String getInterval() {
    return interval;
  }

  public void setInterval(String interval) {
    this.interval = interval;
  }

  public AutomationEntity nextProcessOn(String nextProcessOn) {
    this.nextProcessOn = nextProcessOn;
    return this;
  }

   /**
   * If trigger is &#x60;daily&#x60;, date this automation will next run.
   * @return nextProcessOn
  **/
  @Schema(example = "{}", description = "If trigger is `daily`, date this automation will next run.")
  public String getNextProcessOn() {
    return nextProcessOn;
  }

  public void setNextProcessOn(String nextProcessOn) {
    this.nextProcessOn = nextProcessOn;
  }

  public AutomationEntity schedule(Object schedule) {
    this.schedule = schedule;
    return this;
  }

   /**
   * If trigger is &#x60;custom_schedule&#x60;, Custom schedule description for when the automation should be run.
   * @return schedule
  **/
  @Schema(example = "{\"days_of_week\":[0,2,4],\"times_of_day\":[390,870],\"time_zone\":\"Eastern Time (US & Canada)\"}", description = "If trigger is `custom_schedule`, Custom schedule description for when the automation should be run.")
  public Object getSchedule() {
    return schedule;
  }

  public void setSchedule(Object schedule) {
    this.schedule = schedule;
  }

  public AutomationEntity source(String source) {
    this.source = source;
    return this;
  }

   /**
   * Source Path
   * @return source
  **/
  @Schema(description = "Source Path")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public AutomationEntity destinations(String destinations) {
    this.destinations = destinations;
    return this;
  }

   /**
   * Destination Path
   * @return destinations
  **/
  @Schema(description = "Destination Path")
  public String getDestinations() {
    return destinations;
  }

  public void setDestinations(String destinations) {
    this.destinations = destinations;
  }

  public AutomationEntity destinationReplaceFrom(String destinationReplaceFrom) {
    this.destinationReplaceFrom = destinationReplaceFrom;
    return this;
  }

   /**
   * If set, this string in the destination path will be replaced with the value in &#x60;destination_replace_to&#x60;.
   * @return destinationReplaceFrom
  **/
  @Schema(description = "If set, this string in the destination path will be replaced with the value in `destination_replace_to`.")
  public String getDestinationReplaceFrom() {
    return destinationReplaceFrom;
  }

  public void setDestinationReplaceFrom(String destinationReplaceFrom) {
    this.destinationReplaceFrom = destinationReplaceFrom;
  }

  public AutomationEntity destinationReplaceTo(String destinationReplaceTo) {
    this.destinationReplaceTo = destinationReplaceTo;
    return this;
  }

   /**
   * If set, this string will replace the value &#x60;destination_replace_from&#x60; in the destination filename. You can use special patterns here.
   * @return destinationReplaceTo
  **/
  @Schema(description = "If set, this string will replace the value `destination_replace_from` in the destination filename. You can use special patterns here.")
  public String getDestinationReplaceTo() {
    return destinationReplaceTo;
  }

  public void setDestinationReplaceTo(String destinationReplaceTo) {
    this.destinationReplaceTo = destinationReplaceTo;
  }

  public AutomationEntity path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Path on which this Automation runs.  Supports globs.
   * @return path
  **/
  @Schema(description = "Path on which this Automation runs.  Supports globs.")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public AutomationEntity userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * User ID of the Automation&#x27;s creator.
   * @return userId
  **/
  @Schema(example = "1", description = "User ID of the Automation's creator.")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public AutomationEntity userIds(List<Integer> userIds) {
    this.userIds = userIds;
    return this;
  }

  public AutomationEntity addUserIdsItem(Integer userIdsItem) {
    if (this.userIds == null) {
      this.userIds = new ArrayList<>();
    }
    this.userIds.add(userIdsItem);
    return this;
  }

   /**
   * IDs of Users for the Automation (i.e. who to Request File from)
   * @return userIds
  **/
  @Schema(example = "[1,2]", description = "IDs of Users for the Automation (i.e. who to Request File from)")
  public List<Integer> getUserIds() {
    return userIds;
  }

  public void setUserIds(List<Integer> userIds) {
    this.userIds = userIds;
  }

  public AutomationEntity groupIds(List<Integer> groupIds) {
    this.groupIds = groupIds;
    return this;
  }

  public AutomationEntity addGroupIdsItem(Integer groupIdsItem) {
    if (this.groupIds == null) {
      this.groupIds = new ArrayList<>();
    }
    this.groupIds.add(groupIdsItem);
    return this;
  }

   /**
   * IDs of Groups for the Automation (i.e. who to Request File from)
   * @return groupIds
  **/
  @Schema(example = "[1,2]", description = "IDs of Groups for the Automation (i.e. who to Request File from)")
  public List<Integer> getGroupIds() {
    return groupIds;
  }

  public void setGroupIds(List<Integer> groupIds) {
    this.groupIds = groupIds;
  }

  public AutomationEntity webhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
    return this;
  }

   /**
   * If trigger is &#x60;webhook&#x60;, this is the URL of the webhook to trigger the Automation.
   * @return webhookUrl
  **/
  @Schema(example = "https://app.files.com/api/webhooks/abc123", description = "If trigger is `webhook`, this is the URL of the webhook to trigger the Automation.")
  public String getWebhookUrl() {
    return webhookUrl;
  }

  public void setWebhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
  }

  public AutomationEntity triggerActions(String triggerActions) {
    this.triggerActions = triggerActions;
    return this;
  }

   /**
   * If trigger is &#x60;action&#x60;, this is the list of action types on which to trigger the automation. Valid actions are create, read, update, destroy, move, copy
   * @return triggerActions
  **/
  @Schema(example = "[ \"create\" ]", description = "If trigger is `action`, this is the list of action types on which to trigger the automation. Valid actions are create, read, update, destroy, move, copy")
  public String getTriggerActions() {
    return triggerActions;
  }

  public void setTriggerActions(String triggerActions) {
    this.triggerActions = triggerActions;
  }

  public AutomationEntity triggerActionPath(String triggerActionPath) {
    this.triggerActionPath = triggerActionPath;
    return this;
  }

   /**
   * If trigger is &#x60;action&#x60;, this is the path to watch for the specified trigger actions.
   * @return triggerActionPath
  **/
  @Schema(example = "path/to/file/or/folder", description = "If trigger is `action`, this is the path to watch for the specified trigger actions.")
  public String getTriggerActionPath() {
    return triggerActionPath;
  }

  public void setTriggerActionPath(String triggerActionPath) {
    this.triggerActionPath = triggerActionPath;
  }

  public AutomationEntity value(Object value) {
    this.value = value;
    return this;
  }

   /**
   * A Hash of attributes specific to the automation type.
   * @return value
  **/
  @Schema(example = "{\"limit\": \"1\"}", description = "A Hash of attributes specific to the automation type.")
  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AutomationEntity automationEntity = (AutomationEntity) o;
    return Objects.equals(this.id, automationEntity.id) &&
        Objects.equals(this.automation, automationEntity.automation) &&
        Objects.equals(this.trigger, automationEntity.trigger) &&
        Objects.equals(this.interval, automationEntity.interval) &&
        Objects.equals(this.nextProcessOn, automationEntity.nextProcessOn) &&
        Objects.equals(this.schedule, automationEntity.schedule) &&
        Objects.equals(this.source, automationEntity.source) &&
        Objects.equals(this.destinations, automationEntity.destinations) &&
        Objects.equals(this.destinationReplaceFrom, automationEntity.destinationReplaceFrom) &&
        Objects.equals(this.destinationReplaceTo, automationEntity.destinationReplaceTo) &&
        Objects.equals(this.path, automationEntity.path) &&
        Objects.equals(this.userId, automationEntity.userId) &&
        Objects.equals(this.userIds, automationEntity.userIds) &&
        Objects.equals(this.groupIds, automationEntity.groupIds) &&
        Objects.equals(this.webhookUrl, automationEntity.webhookUrl) &&
        Objects.equals(this.triggerActions, automationEntity.triggerActions) &&
        Objects.equals(this.triggerActionPath, automationEntity.triggerActionPath) &&
        Objects.equals(this.value, automationEntity.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, automation, trigger, interval, nextProcessOn, schedule, source, destinations, destinationReplaceFrom, destinationReplaceTo, path, userId, userIds, groupIds, webhookUrl, triggerActions, triggerActionPath, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AutomationEntity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    automation: ").append(toIndentedString(automation)).append("\n");
    sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
    sb.append("    interval: ").append(toIndentedString(interval)).append("\n");
    sb.append("    nextProcessOn: ").append(toIndentedString(nextProcessOn)).append("\n");
    sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    destinations: ").append(toIndentedString(destinations)).append("\n");
    sb.append("    destinationReplaceFrom: ").append(toIndentedString(destinationReplaceFrom)).append("\n");
    sb.append("    destinationReplaceTo: ").append(toIndentedString(destinationReplaceTo)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    userIds: ").append(toIndentedString(userIds)).append("\n");
    sb.append("    groupIds: ").append(toIndentedString(groupIds)).append("\n");
    sb.append("    webhookUrl: ").append(toIndentedString(webhookUrl)).append("\n");
    sb.append("    triggerActions: ").append(toIndentedString(triggerActions)).append("\n");
    sb.append("    triggerActionPath: ").append(toIndentedString(triggerActionPath)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
