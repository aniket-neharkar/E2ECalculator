package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public Object[][] getDataForHomeLoan()
    {
        Object[][] data = new Object[3][5];

        data[0][0] = "500000";
        data[0][1] = "7.5";
        data[0][2] = "10";
        data[0][3] = "5,935";
        data[0][4] = "2,12,211";

        data[1][0] = "500000";
        data[1][1] = "8";
        data[1][2] = "15";
        data[1][3] = "4,778";
        data[1][4] = "3,60,087";

        data[2][0] = "800000";
        data[2][1] = "8";
        data[2][2] = "15";
        data[2][3] = "7,545";
        data[2][4] = "5,76,039";

        return data;
    }

    @DataProvider
    public Object[][] getDataForPersonalLoan()
    {
        Object[][] data = new Object[4][5];

        data[0][0] = "500000";
        data[0][1] = "13";
        data[0][2] = "4";
        data[0][3] = "13,414";
        data[0][4] = "1,43,860";

        data[1][0] = "400000";
        data[1][1] = "15";
        data[1][2] = "3";
        data[1][3] = "13,866";
        data[1][4] = "99,181";

        data[2][0] = "450000";
        data[2][1] = "13.5";
        data[2][2] = "2";
        data[2][3] = "21,500";
        data[2][4] = "65,992";

        data[3][0] = "1000000";
        data[3][1] = "12";
        data[3][2] = "5";
        data[3][3] = "22,244";
        data[3][4] = "3,34,667";

        return data;
    }

    @DataProvider
    public Object[][] getDataForCarLoan()
    {
        Object[][] data = new Object[2][5];

        data[0][0] = "400000";
        data[0][1] = "12.5";
        data[0][2] = "5";
        data[0][3] = "8,999";
        data[0][4] = "1,39,951";

        data[1][0] = "500000";
        data[1][1] = "10";
        data[1][2] = "6";
        data[1][3] = "9,263";
        data[1][4] = "1,66,930";

        return data;
    }

}