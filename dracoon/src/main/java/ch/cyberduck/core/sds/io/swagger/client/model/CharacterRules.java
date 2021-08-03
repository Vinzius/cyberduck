/*
 * DRACOON API
 * REST Web Services for DRACOON<br>built at: 1970-01-01 00:00:00.000<br><br>This page provides an overview of all available and documented DRACOON APIs, which are grouped by tags.<br>Each tag provides a collection of APIs that are intended for a specific area of the DRACOON.<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a><br><br><a title='Terms of service' href='https://www.dracoon.com/terms/general-terms-and-conditions/'>Terms of service</a>
 *
 * OpenAPI spec version: 4.28.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * Password character rules
 */
@Schema(description = "Password character rules")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T23:34:01.480829+02:00[Europe/Paris]")
public class CharacterRules {
  /**
   * Characters which a password must contain:  * &#x60;alpha&#x60; - at least one alphabetical character (&#x60;uppercase&#x60; OR &#x60;lowercase&#x60;)  * &#x60;uppercase&#x60; - at least one uppercase character  * &#x60;lowercase&#x60; - at least one lowercase character  * &#x60;numeric&#x60; - at least one numeric character  * &#x60;special&#x60; - at least one special character (letters and digits excluded)  * &#x60;all&#x60; - combination of &#x60;uppercase&#x60;, &#x60;lowercase&#x60;, &#x60;numeric&#x60; and &#x60;special&#x60; (available only in request models)  * &#x60;none&#x60; - none of the above
   */
  public enum MustContainCharactersEnum {
    ALPHA("alpha"),
    UPPERCASE("uppercase"),
    LOWERCASE("lowercase"),
    NUMERIC("numeric"),
    SPECIAL("special"),
    ALL("all"),
    NONE("none");

    private String value;

    MustContainCharactersEnum(String value) {
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
    public static MustContainCharactersEnum fromValue(String text) {
      for (MustContainCharactersEnum b : MustContainCharactersEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("mustContainCharacters")
  private List<MustContainCharactersEnum> mustContainCharacters = new ArrayList<>();

  @JsonProperty("numberOfCharacteristicsToEnforce")
  private Integer numberOfCharacteristicsToEnforce = null;

  public CharacterRules mustContainCharacters(List<MustContainCharactersEnum> mustContainCharacters) {
    this.mustContainCharacters = mustContainCharacters;
    return this;
  }

  public CharacterRules addMustContainCharactersItem(MustContainCharactersEnum mustContainCharactersItem) {
    this.mustContainCharacters.add(mustContainCharactersItem);
    return this;
  }

   /**
   * Characters which a password must contain:  * &#x60;alpha&#x60; - at least one alphabetical character (&#x60;uppercase&#x60; OR &#x60;lowercase&#x60;)  * &#x60;uppercase&#x60; - at least one uppercase character  * &#x60;lowercase&#x60; - at least one lowercase character  * &#x60;numeric&#x60; - at least one numeric character  * &#x60;special&#x60; - at least one special character (letters and digits excluded)  * &#x60;all&#x60; - combination of &#x60;uppercase&#x60;, &#x60;lowercase&#x60;, &#x60;numeric&#x60; and &#x60;special&#x60; (available only in request models)  * &#x60;none&#x60; - none of the above
   * @return mustContainCharacters
  **/
  @Schema(required = true, description = "Characters which a password must contain:  * `alpha` - at least one alphabetical character (`uppercase` OR `lowercase`)  * `uppercase` - at least one uppercase character  * `lowercase` - at least one lowercase character  * `numeric` - at least one numeric character  * `special` - at least one special character (letters and digits excluded)  * `all` - combination of `uppercase`, `lowercase`, `numeric` and `special` (available only in request models)  * `none` - none of the above")
  public List<MustContainCharactersEnum> getMustContainCharacters() {
    return mustContainCharacters;
  }

  public void setMustContainCharacters(List<MustContainCharactersEnum> mustContainCharacters) {
    this.mustContainCharacters = mustContainCharacters;
  }

  public CharacterRules numberOfCharacteristicsToEnforce(Integer numberOfCharacteristicsToEnforce) {
    this.numberOfCharacteristicsToEnforce = numberOfCharacteristicsToEnforce;
    return this;
  }

   /**
   * Number of characteristics to enforce  e.g. from &#x60;[\&quot;uppercase\&quot;, \&quot;lowercase\&quot;, \&quot;numeric\&quot;, \&quot;special\&quot;]&#x60;  all 4 character sets can be enforced; but also only 2 of them
   * minimum: 0
   * maximum: 4
   * @return numberOfCharacteristicsToEnforce
  **/
  @Schema(required = true, description = "Number of characteristics to enforce  e.g. from `[\"uppercase\", \"lowercase\", \"numeric\", \"special\"]`  all 4 character sets can be enforced; but also only 2 of them")
  public Integer getNumberOfCharacteristicsToEnforce() {
    return numberOfCharacteristicsToEnforce;
  }

  public void setNumberOfCharacteristicsToEnforce(Integer numberOfCharacteristicsToEnforce) {
    this.numberOfCharacteristicsToEnforce = numberOfCharacteristicsToEnforce;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CharacterRules characterRules = (CharacterRules) o;
    return Objects.equals(this.mustContainCharacters, characterRules.mustContainCharacters) &&
        Objects.equals(this.numberOfCharacteristicsToEnforce, characterRules.numberOfCharacteristicsToEnforce);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mustContainCharacters, numberOfCharacteristicsToEnforce);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CharacterRules {\n");
    
    sb.append("    mustContainCharacters: ").append(toIndentedString(mustContainCharacters)).append("\n");
    sb.append("    numberOfCharacteristicsToEnforce: ").append(toIndentedString(numberOfCharacteristicsToEnforce)).append("\n");
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
