package org.moonzhou.dailyprogramming;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description: test complex object
 * @date 2022/10/8 14:56
 */
public class TestJacksonFromJson2 {

    public static void main(String[] args) throws Exception {

        File file = new File("/Users/XXX/tmp/leaveinfoEN.json");

        String json = FileUtils.readFileToString(file, "utf-8");;

        ObjectMapper objectMapper = new ObjectMapper();
        LeaveInfo leaveInfo = objectMapper.readValue(json, LeaveInfo.class);
        System.out.println(leaveInfo);
    }

    @Getter
    @Setter
    public static class LeaveInfo {
        private List<LeaveType> leaveType;
        private List<LeaveArray> leaveArray;
        private List<RegionArray> regionArray;
    }

    @Getter
    @Setter
    public static class LeaveType {
        private String name;
        private String value;

        private Boolean enclosureFlag;
        private List<EnclosureArray> enclosureArray;
        private Boolean enclosureMad;

        private Boolean levelone;

        private Boolean startDateFlag;
        private Boolean startDateMad;
        private Boolean endDateFlag;
        private Boolean endDateMad;

        private Boolean leaveDaysFlag;
        private Boolean leaveDaysMad;
        private List<LeaveDaysArray> leaveDaysArray;

        private Boolean beginTimeFlag;
        private Boolean beginTimeMad;
        private Boolean endTimeFlag;
        private Boolean endTimeMad;

        private Boolean note;
        private Boolean noteMad;

        private Boolean relationshipFlag;
        private List<RelationshipArray> relationshipArray;
        private Boolean relationshipMad;

        private List<DetailsArray> detailsArray;
        private String vacationDetails;
        private Boolean isShow;
        private String showContent;


        @Getter
        @Setter
        public static class EnclosureArray {
            private String type;
            private String value;
            private String text;
            private String enclosureChildMad;
        }

        @Getter
        @Setter
        public static class LeaveDaysArray {
            private String value;
            private String text;
        }

        @Getter
        @Setter
        public static class RelationshipArray {
            private String value;
            private String text;
        }

        @Getter
        @Setter
        public static class DetailsArray {
            private String werks;
            private String btrtl;
            private String value;
            private String text;
        }
    }

    @Getter
    @Setter
    public static class LeaveArray {
        private String value;
        private String text;
    }

    @Getter
    @Setter
    public static class RegionArray {
        private String werks;
        private String btrtl;
        private String value;
        private String text;
    }
}
