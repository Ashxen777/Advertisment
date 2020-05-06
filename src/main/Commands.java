package main;

public interface Commands {
    int EXIT=0;
    int LOGIN=1;
    int REGISTER=2;

    int LOGOUT=0;
    int ADD_NEW_AD=1;
    int PRINT_MY_ADS=2;
    int PRINT_ALL_ADS=3;
    int PRINT_ALL_BY_CATEGORY=4;
    int PRINT_ALL_ADS_SORT_BY_TITLE=5;
    int PRINT_ALL_ADS_SORT_BY_DATE=6;
    int DELETE_MY_ALL_ADS=7;
    int DELETE_ADS_BY_ID=8;

    static void printMainCommands(){
        System.out.println("Please input "+EXIT+" for EXIT");
        System.out.println("Please input "+LOGIN+" for LOGIN");
        System.out.println("Please input "+REGISTER+" for REGISTER");
    }

    static void printUserCommands(){
        System.out.println("Please input "+LOGOUT+" for LOGOUT");
        System.out.println("Please input "+ADD_NEW_AD+" for ADD_NEW_AD");
        System.out.println("Please input "+PRINT_MY_ADS+" for PRINT_MY_ADS");
        System.out.println("Please input "+PRINT_ALL_ADS+" for PRINT_ALL_ADS");
        System.out.println("Please input "+PRINT_ALL_BY_CATEGORY+" for PRINT_ALL_BY_CATEGORY");
        System.out.println("Please input "+ PRINT_ALL_ADS_SORT_BY_TITLE+" for  PRINT_ALL_ADS_SORT_BY_TITLE");
        System.out.println("Please input "+PRINT_ALL_ADS_SORT_BY_DATE+" for PRINT_ALL_ADS_SORT_BY_DATE");
        System.out.println("Please input "+DELETE_MY_ALL_ADS+" or DELETE_MY_ALL_ADS");
        System.out.println("Please input "+DELETE_ADS_BY_ID+" for DELETE_ADS_BY_ID");
    }
}
