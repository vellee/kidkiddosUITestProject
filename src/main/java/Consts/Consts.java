package Consts;

public class Consts {

    public static final String MAIN_URL = "https://kidkiddos.com/";
    public static final String CONTACT_US_URL = "https://kidkiddos.com/pages/contact-us";

    // Correct values for drop-down box "Books by Language" from upper menu
    public enum LANGUAGES {
        ALBANIAN("Albanian - Shqip"),
        DUTCH("Dutch - Nederlands"),
        ENGLISH("English Only");
        //HUNGARIAN("Hungarian - Magyar");
        //UKRAINIAN("Ukrainian - Українська"),
        //VIETNAMESE("Vietnamese - Tiếng Việt");


        private String name;

        // Constructor for Enum values
        LANGUAGES(String name) {
            this.name = name;
        }

        // Getter for Enum values
        public String getName() {
            return this.name;
        }
    }
    public enum ALL_LANGUAGES {

        HUNGARIAN("Hungarian - Magyar"),
        UKRAINIAN("Ukrainian - Українська"),
        VIETNAMESE("Vietnamese - Tiếng Việt");


        private String name;

        // Constructor for Enum values
        ALL_LANGUAGES(String name) {
            this.name = name;
        }

        // Getter for Enum values
        public String getName() {
            return this.name;
        }
    }

}
