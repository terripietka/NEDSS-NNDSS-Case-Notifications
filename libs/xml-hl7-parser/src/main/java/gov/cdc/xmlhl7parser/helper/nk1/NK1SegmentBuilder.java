package gov.cdc.xmlhl7parser.helper.nk1;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v25.segment.NK1;
import gov.cdc.xmlhl7parser.helper.MessageState;
import gov.cdc.xmlhl7parser.model.generated.jaxb.MessageElement;
import org.springframework.stereotype.Component;

@Component
public class NK1SegmentBuilder {

  public void processNK1Fields(MessageElement messageElement, NK1 nk1, MessageState messageState)
      throws DataTypeException {

    String nk1Field = messageElement.getHl7SegmentField().trim();

    nk1.getSetIDNK1().setValue("1");

    if (nk1Field.equals("NK1-3.0")) {

      nk1.getNk13_Relationship()
          .getIdentifier()
          .setValue(messageElement.getDataElement().getCeDataType().getCeCodedValue());
      nk1.getNk13_Relationship()
          .getText()
          .setValue(messageElement.getDataElement().getCeDataType().getCeCodedValueDescription());
      nk1.getNk13_Relationship()
          .getNameOfCodingSystem()
          .setValue(messageElement.getDataElement().getCeDataType().getCeCodedValueCodingSystem());

    } else if (nk1Field.equals("NK1-4.4")) {

      nk1.getNk14_Address(0)
          .getStateOrProvince()
          .setValue(messageElement.getDataElement().getCweDataType().getCweCodedValue());

    } else if (nk1Field.equals("NK1-4.5")) {

      nk1.getNk14_Address(0)
          .getZipOrPostalCode()
          .setValue(messageElement.getDataElement().getStDataType().getStringData());

    } else if (nk1Field.equals("NK1-4.6")) {

      nk1.getNk14_Address(0)
          .getCountry()
          .setValue(messageElement.getDataElement().getCweDataType().getCweCodedValue());

    } else if (nk1Field.equals("NK1-4.9")) {

      nk1.getNk14_Address(0)
          .getCountyParishCode()
          .setValue(messageElement.getDataElement().getCweDataType().getCweCodedValue());

    } else if (nk1Field.equals("NK1-14.0")) {

      nk1.getNk114_MaritalStatus()
          .getIdentifier()
          .setValue(messageElement.getDataElement().getCeDataType().getCeCodedValue());
      nk1.getNk114_MaritalStatus()
          .getText()
          .setValue(messageElement.getDataElement().getCeDataType().getCeCodedValueDescription());
      nk1.getNk114_MaritalStatus()
          .getNameOfCodingSystem()
          .setValue(messageElement.getDataElement().getCeDataType().getCeCodedValueCodingSystem());

    } else if (nk1Field.equals("NK1-16.0")) {

      String rawBirthDate = messageElement.getDataElement().getTsDataType().getTime().toString();

      String birthDate;
      if (rawBirthDate.length() >= 10) {
        birthDate = rawBirthDate.substring(0, 10).replace("-", "");
      } else {
        birthDate = rawBirthDate.replace("-", "");
      }

      nk1.getNk116_DateTimeOfBirth().getTime().setValue(birthDate);

    } else if (nk1Field.equals("NK1-28.0")) {

      String ceCodedValue =
          messageElement.getDataElement().getCeDataType().getCeCodedValue().trim();
      String ceCodedValueDescription =
          messageElement.getDataElement().getCeDataType().getCeCodedValueDescription().trim();
      String ceCodedValueCodingSystem =
          messageElement.getDataElement().getCeDataType().getCeCodedValueCodingSystem().trim();
      String ceLocalCodedValue =
          messageElement.getDataElement().getCeDataType().getCeLocalCodedValue().trim();
      String ceLocalCodedValueDescription =
          messageElement.getDataElement().getCeDataType().getCeLocalCodedValueDescription().trim();
      String ceLocalCodedValueCodingSystem =
          messageElement.getDataElement().getCeDataType().getCeLocalCodedValueCodingSystem().trim();

      nk1.getNk128_EthnicGroup(0).getIdentifier().setValue(ceCodedValue);
      nk1.getNk128_EthnicGroup(0).getText().setValue(ceCodedValueDescription);
      nk1.getNk128_EthnicGroup(0).getNameOfCodingSystem().setValue(ceCodedValueCodingSystem);
      nk1.getNk128_EthnicGroup(0).getAlternateIdentifier().setValue(ceLocalCodedValue);
      nk1.getNk128_EthnicGroup(0).getAlternateText().setValue(ceLocalCodedValueDescription);
      nk1.getNk128_EthnicGroup(0)
          .getNameOfAlternateCodingSystem()
          .setValue(ceLocalCodedValueCodingSystem);

    } else if (nk1Field.equals("NK1-35.0")) {

      String ceCodedValue =
          messageElement.getDataElement().getCeDataType().getCeCodedValue().trim();
      String ceCodedValueDescription =
          messageElement.getDataElement().getCeDataType().getCeCodedValueDescription().trim();
      String ceCodedValueCodingSystem =
          messageElement.getDataElement().getCeDataType().getCeCodedValueCodingSystem().trim();
      String ceLocalCodedValue =
          messageElement.getDataElement().getCeDataType().getCeLocalCodedValue().trim();
      String ceLocalCodedValueDescription =
          messageElement.getDataElement().getCeDataType().getCeLocalCodedValueDescription().trim();
      String ceLocalCodedValueCodingSystem =
          messageElement.getDataElement().getCeDataType().getCeLocalCodedValueCodingSystem().trim();

      nk1.getNk135_Race(messageState.getNk1RaceIndex()).getIdentifier().setValue(ceCodedValue);
      nk1.getNk135_Race(messageState.getNk1RaceIndex()).getText().setValue(ceCodedValueDescription);
      nk1.getNk135_Race(messageState.getNk1RaceIndex())
          .getNameOfCodingSystem()
          .setValue(ceCodedValueCodingSystem);
      nk1.getNk135_Race(messageState.getNk1RaceIndex())
          .getAlternateIdentifier()
          .setValue(ceLocalCodedValue);
      nk1.getNk135_Race(messageState.getNk1RaceIndex())
          .getAlternateText()
          .setValue(ceLocalCodedValueDescription);
      nk1.getNk135_Race(messageState.getNk1RaceIndex())
          .getNameOfAlternateCodingSystem()
          .setValue(ceLocalCodedValueCodingSystem);

      messageState.setNk1RaceIndex(messageState.getNk1RaceIndex() + 1);
    }
  }
}
