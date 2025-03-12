/*
 * Kingdom of War - Global Conquest
 * Created by Liam Ralph
 */

// IMPORTS
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class KingdomOfWarGlobalConquest{
    // VARIABLES

    // Version
    static String version = "v1.0.0";

    // Directory
    static final String FILE_DIRECTORY = "Text Files/";
    
    // Scanner
	static Scanner scanner = new Scanner(System.in);

    // Random
    static Random random = new Random();

    // Ansi Text Colors
    static final String RED_TEXT = "\u001b[31;1m";
    static final String YELLOW_TEXT = "\u001b[33;1m";
    static final String GREEN_TEXT = "\u001b[32;1m";
    static final String PURPLE_TEXT = "\u001b[35;1m";

    // Ansi Color Lists
    static final String[] RED_COLOR_LIST = {"52", "88", "124", "160"};
    static final String[] ORANGE_COLOR_LIST = {"166", "202", "208", "214"};
    static final String[] YELLOW_COLOR_LIST = {"11", "221", "227", "228"};
    static final String[] GREEN_COLOR_LIST = {"22", "28", "34", "40"};
    static final String[] BLUE_COLOR_LIST = {"33", "39", "45", "87"};
    static final String[] PURPLE_COLOR_LIST = {"54", "55", "56", "57"};
    static final String[] PINK_COLOR_LIST = {"197", "200", "207", "213"};
    static final String[] TEAL_COLOR_LIST = {"23", "29", "35", "41"};
    static final String[] BLACK_COLOR_LIST = {"16", "232", "233", "234"};
    static final String[] GRAY_COLOR_LIST = {"239", "242", "245", "248"};

    // Ansi Reset
    static final String ANSI_RESET = "\u001b[0m";

    // Map Data
    static final String FOREGROUND_TEXT =
        readFile("Foreground.txt").replace(" ", "▄");
    static final String[] BACKGROUND_CODES =
        readFile("Background.txt").split("\n");

    // Number Formatting Preference
    static String numSeparator;
    static String numDecimal;

    // Map Information Choices
    // 1 = Soldiers, 2 = Bombs, 3 = Nuclear Weapons
    static int mapInfoChoice1 = 1;
    static int mapInfoChoice2 = 2;

    /*
     * Countries
     * Creating countries with name, abbreviation, color level
     * (used in map printing), and area
     */
    static Country Yukon = new Country("Yukon", "YKN", 1, 33);
    static Country NWCanada = new Country("NW Canada", "NWT", 3, 76);
    static Country Nunavut = new Country("Nunavut", "NVT", 2, 147);
    static Country BritishColombia =
        new Country("British Colombia", "BCO", 2, 39);
    static Country CCanada = new Country("C Canada", "CCA", 4, 81);
    static Country ECanada = new Country("E Canada", "ECA", 1, 120);
    static Country WGreenland = new Country("W Greenland", "WGL", 4, 91);
    static Country EGreenland = new Country("E Greenland", "EGL", 1, 86);
    static Country SGreenland = new Country("S Greenland", "SGL", 2, 68);
    static Country Alaska = new Country("Alaska", "ASK", 3, 86);
    static Country Hawaii = new Country("Hawaii", "HAI", 4, 7);
    static Country WUnitedStates =
        new Country("W United States", "WUS", 1, 69);
    static Country CUnitedStates =
        new Country("C United States", "CUS", 3, 44);
    static Country SUnitedStates =
        new Country("S United States", "SUS", 4, 55);
    static Country NUnitedStates =
        new Country("N United States", "NUS", 2, 16);
    static Country NCentralAmerica =
        new Country("N Central America", "NCA", 2, 49);
    static Country SCentralAmerica =
        new Country("S Central America", "SCA", 1, 25);
    static Country Caribbean = new Country("Caribbean", "CAR", 3, 14);
    static Country NSouthAmerica =
        new Country("N South America", "NSA", 2, 39);
    static Country Peru = new Country("Peru", "PER", 4, 18);
    static Country NBrazil = new Country("N Brazil", "NBR", 3, 89);
    static Country SBrazil = new Country("S Brazil", "SBR", 2, 52);
    static Country Chile = new Country("Chile", "CHL", 3, 18);
    static Country SSouthAmerica =
        new Country("S South America", "SSA", 1, 100);
    static Country Britain = new Country("Britain", "BRT", 1, 17);
    static Country Scandinavia = new Country("Scandinavia", "SCD", 2, 71);
    static Country Iceland = new Country("Iceland", "ICL", 4, 5);
    static Country Finland = new Country("Finland", "FIN", 3, 29);
    static Country WEurope = new Country("W Europe", "WEU", 2, 50);
    static Country CEurope = new Country("C Europe", "CEU", 4, 49);
    static Country SEurope = new Country("S Europe", "SEU", 3, 40);
    static Country EEurope = new Country("E Europe", "EEU", 2, 40);
    static Country NWRussia = new Country("NW Russia", "NWR", 1, 106);
    static Country SWRussia = new Country("SW Russia", "SWR", 4, 69);
    static Country NWAfrica = new Country("NW Africa", "NWA", 3, 13);
    static Country Algeria = new Country("Algeria", "ALG", 1, 40);
    static Country NAfrica = new Country("N Africa", "NAF", 4, 50);
    static Country WAfrica = new Country("W Africa", "WAF", 2, 70);
    static Country NEAfrica = new Country("NE Africa", "NEA", 1, 61);
    static Country NCAfrica = new Country("NC Africa", "NCF", 3, 39);
    static Country EAfrica = new Country("E Africa", "EAF", 4, 65);
    static Country SEAfrica = new Country("SE Africa", "SEF", 3, 42);
    static Country SCAfrica = new Country("SC Africa", "SCF", 2, 59);
    static Country Madagascar = new Country("Madagascar", "MDG", 4, 13);
    static Country SAfrica = new Country("S Africa", "SAF", 4, 47);
    static Country Ural = new Country("Ural", "URA", 2, 103);
    static Country NSiberia = new Country("N Siberia", "NSI", 4, 167);
    static Country SSiberia = new Country("S Siberia", "SSI", 1, 74);
    static Country Sakha = new Country("Sakha", "SAK", 2, 144);
    static Country SERussia = new Country("SE Russia", "SER", 3, 54);
    static Country ERussia = new Country("E Russia", "ERU", 1, 104);
    static Country Turkey = new Country("Turkey", "TUR", 1, 20);
    static Country Arabia = new Country("Arabia", "ARB", 3, 51);
    static Country Iran = new Country("Iran", "IRN", 2, 27);
    static Country CAsia = new Country("C Asia", "CAS", 1, 35);
    static Country Kazakhstan = new Country("Kazakhstan", "KAZ", 3, 63);
    static Country Mongolia = new Country("Mongolia", "MNG", 4, 45);
    static Country NWChina = new Country("NW China", "NWC", 2, 52);
    static Country SWChina = new Country("SW China", "SWC", 4, 51);
    static Country NEChina = new Country("NE China", "NEC", 1, 69);
    static Country SEChina = new Country("SE China", "SEC", 3, 45);
    static Country Korea = new Country("Korea", "KOR", 4, 16);
    static Country Japan = new Country("Japan", "JPN", 2, 29);
    static Country SAsia = new Country("S Asia", "SAS", 3, 66);
    static Country SEAsia = new Country("SE Asia", "SEA", 1, 38);
    static Country Indonesia = new Country("Indonesia", "IDN", 4, 34);
    static Country WAustralia = new Country("W Australia", "WAU", 1, 52);
    static Country NAustralia = new Country("N Australia", "NAU", 2, 57);
    static Country SAustralia = new Country("S Australia", "SAU", 4, 48);
    static Country Tasmania = new Country("Tasmania", "TAS", 3, 4);
    static Country NewGuinea = new Country("New Guinea", "NGU", 3, 21);
    static Country NewZealand = new Country("New Zealand", "NZL", 1, 17);

    // Continent Lists
    static Country[] northAmerica = {Yukon, NWCanada, Nunavut,
        BritishColombia, CCanada, ECanada, WGreenland, EGreenland, SGreenland,
        Alaska, Hawaii, WUnitedStates, CUnitedStates, SUnitedStates,
        NUnitedStates, NCentralAmerica, SCentralAmerica, Caribbean};
    static Country[] southAmerica = {NSouthAmerica, Peru, NBrazil, SBrazil,
        Chile, SSouthAmerica};
    static Country[] europe = {Britain, Scandinavia, Iceland, Finland,
        WEurope, CEurope, SEurope, EEurope, NWRussia, SWRussia};
    static Country[] africa = {NWAfrica, Algeria, NAfrica, WAfrica, NEAfrica,
        NCAfrica, EAfrica, SEAfrica, SCAfrica, Madagascar, SAfrica};
    static Country[] asia = {Ural, NSiberia, SSiberia, Sakha, SERussia,
        ERussia, Turkey, Arabia, Iran, CAsia, Kazakhstan, Mongolia, NWChina,
        SWChina, NEChina, SEChina, Korea, Japan, SAsia, SEAsia, Indonesia};
    static Country[] oceania = {WAustralia, NAustralia, SAustralia, Tasmania,
        NewGuinea, NewZealand};
    // Region Lists
    static Country[] greenland = {EGreenland, WGreenland, SGreenland};
    static Country[] canada = {Yukon, NWCanada, Nunavut, BritishColombia,
        CCanada, ECanada};
    static Country[] unitedStates = {Alaska, Hawaii, WUnitedStates,
        CUnitedStates, SUnitedStates, NUnitedStates};
    static Country[] northLatinAmerica = {NCentralAmerica, SCentralAmerica,
        Caribbean, NSouthAmerica, Peru};
    static Country[] southLatinAmerica = {NBrazil, SBrazil, Chile,
        SSouthAmerica};
    static Country[] northernEurope = {Iceland, Scandinavia, Finland,
        Britain};
    static Country[] southernEurope = {WEurope, CEurope, SEurope, EEurope};
    static Country[] northAfrica = {NWAfrica, Algeria, NAfrica};
    static Country[] centralAfrica = {WAfrica, NEAfrica, NCAfrica, EAfrica};
    static Country[] southAfrica = {SCAfrica, SEAfrica, Madagascar, SAfrica};
    static Country[] westernRussia = {NWRussia, SWRussia, Ural, NSiberia};
    static Country[] easternRussia = {SSiberia, Sakha, SERussia, ERussia};
    static Country[] westAsia = {Turkey, Arabia, Iran, CAsia, Kazakhstan};
    static Country[] eastAsia = {NWChina, SWChina, SEChina, SWChina,
        Mongolia};
    static Country[] southAsia = {SAsia, SEAsia, Indonesia};
    static Country[] pacific = {Korea, Japan, NewGuinea, NewZealand};
    static Country[] australia = {WAustralia, NAustralia, SAustralia,
        Tasmania};
    // List of All Countries
    static Country[] countries = new Country[72];

    // Player List
    static ArrayList<Player> players = new ArrayList<Player>();

    // METHODS

    // Main Method

    public static void main(String[] args){

        // SETUP

        // --Neutral Player--
        // Used to represent neutral countries, doesn't actually play
        Player playerNeutral = new Player( /* true,  Removed until v2.0.0 */
            "Neutral", 'n');
        playerNeutral.money = 0;
        playerNeutral.reserveSoldiers = 0;

        // --Coutry Adjacent and Bomb/Nuclear Weapon Range Lists--
        // -Country Adjacent Lists-
        // Each country's list of countries adjacent to it
        Yukon.adjacentCountries = new Country[]{NWCanada, BritishColombia,
            Alaska};
        NWCanada.adjacentCountries = new Country[]{Yukon, Nunavut, CCanada};
        Nunavut.adjacentCountries = new Country[]{NWCanada, CCanada, ECanada,
            WGreenland};
        BritishColombia.adjacentCountries = new Country[]{Yukon, CCanada,
            Alaska, WUnitedStates};
        CCanada.adjacentCountries = new Country[]{NWCanada, Nunavut,
            BritishColombia, ECanada, WUnitedStates, CUnitedStates};
        ECanada.adjacentCountries = new Country[]{CCanada, CUnitedStates,
            NUnitedStates, SGreenland, Nunavut};
        WGreenland.adjacentCountries = new Country[]{EGreenland, SGreenland,
            Nunavut};
        EGreenland.adjacentCountries = new Country[]{WGreenland, SGreenland,
            Scandinavia};
        SGreenland.adjacentCountries = new Country[]{WGreenland, EGreenland,
            Britain, Iceland, ECanada};
        Alaska.adjacentCountries = new Country[]{Yukon, BritishColombia,
            ERussia, Hawaii};
        Hawaii.adjacentCountries = new Country[]{Japan, WUnitedStates,
            Alaska};
        WUnitedStates.adjacentCountries = new Country[]{BritishColombia,
            CCanada, CUnitedStates, SUnitedStates, NCentralAmerica, Hawaii};
        CUnitedStates.adjacentCountries = new Country[]{CCanada, ECanada,
            WUnitedStates, SUnitedStates, NUnitedStates};
        SUnitedStates.adjacentCountries = new Country[]{WUnitedStates,
            CUnitedStates, NUnitedStates, NCentralAmerica, Caribbean};
        NUnitedStates.adjacentCountries = new Country[]{ECanada,
            CUnitedStates, SUnitedStates};
        NCentralAmerica.adjacentCountries = new Country[]{WUnitedStates,
            SUnitedStates, SCentralAmerica};
        SCentralAmerica.adjacentCountries = new Country[]{NCentralAmerica,
            NSouthAmerica, Caribbean};
        Caribbean.adjacentCountries = new Country[]{NSouthAmerica,
            SCentralAmerica, SUnitedStates};
        NSouthAmerica.adjacentCountries = new Country[]{SCentralAmerica,
            Peru, NBrazil, Caribbean};
        Peru.adjacentCountries = new Country[]{NSouthAmerica, NBrazil,
            SBrazil, Chile, SSouthAmerica, NewZealand};
        NBrazil.adjacentCountries = new Country[]{NSouthAmerica, Peru,
            SBrazil, WAfrica};
        SBrazil.adjacentCountries = new Country[]{Peru, NBrazil,
            SSouthAmerica};
        Chile.adjacentCountries = new Country[]{Peru, SSouthAmerica};
        SSouthAmerica.adjacentCountries = new Country[]{Peru, SBrazil, Chile};
        Britain.adjacentCountries = new Country[]{Iceland, Scandinavia,
            SGreenland, WEurope};
        Scandinavia.adjacentCountries = new Country[]{Finland, CEurope,
            Iceland, Britain, EGreenland};
        Iceland.adjacentCountries = new Country[]{Scandinavia, Britain,
            SGreenland};
        Finland.adjacentCountries = new Country[]{Scandinavia, EEurope,
            NWRussia};
        WEurope.adjacentCountries = new Country[]{CEurope, SEurope, NWAfrica,
            Britain};
        CEurope.adjacentCountries = new Country[]{Scandinavia, WEurope,
            SEurope, EEurope};
        SEurope.adjacentCountries = new Country[]{WEurope, CEurope, EEurope,
            Turkey, NAfrica};
        EEurope.adjacentCountries = new Country[]{Finland, CEurope, SEurope,
            NWRussia, SWRussia, Turkey};
        NWRussia.adjacentCountries = new Country[]{Finland, EEurope,
            SWRussia, Ural};
        SWRussia.adjacentCountries = new Country[]{EEurope, NWRussia, Ural,
            Turkey, Iran, Kazakhstan};
        NWAfrica.adjacentCountries = new Country[]{WEurope, Algeria, WAfrica};
        Algeria.adjacentCountries = new Country[]{NWAfrica, NAfrica, WAfrica};
        NAfrica.adjacentCountries = new Country[]{Algeria, WAfrica, NEAfrica,
            Arabia, SEurope};
        WAfrica.adjacentCountries = new Country[]{NWAfrica, Algeria, NAfrica,
            NEAfrica, NCAfrica, NBrazil};
        NEAfrica.adjacentCountries = new Country[]{NAfrica, WAfrica,
            NCAfrica, EAfrica, Arabia};
        NCAfrica.adjacentCountries = new Country[]{WAfrica, NEAfrica,
            EAfrica, SCAfrica};
        EAfrica.adjacentCountries = new Country[]{NEAfrica, NCAfrica,
            SEAfrica, SCAfrica};
        SEAfrica.adjacentCountries = new Country[]{EAfrica, SCAfrica,
            SAfrica};
        SCAfrica.adjacentCountries = new Country[]{NCAfrica, EAfrica,
            SEAfrica, SAfrica};
        Madagascar.adjacentCountries = new Country[]{WAustralia, SEAfrica};
        SAfrica.adjacentCountries = new Country[]{SEAfrica, SCAfrica};
        Ural.adjacentCountries = new Country[]{NWRussia, SWRussia, NSiberia,
            SSiberia, Kazakhstan};
        NSiberia.adjacentCountries = new Country[]{Ural, SSiberia, Sakha};
        SSiberia.adjacentCountries = new Country[]{Ural, NSiberia, Sakha,
            SERussia, Kazakhstan, Mongolia, NWChina};
        Sakha.adjacentCountries = new Country[]{NSiberia, SSiberia, SERussia,
            ERussia};
        SERussia.adjacentCountries = new Country[]{SSiberia, Sakha, ERussia,
            Mongolia, NEChina, Korea, Japan};
        ERussia.adjacentCountries = new Country[]{Sakha, SERussia, Alaska,
            Japan};
        Turkey.adjacentCountries = new Country[]{SEurope, SWRussia, Arabia,
            Iran, EEurope};
        Arabia.adjacentCountries = new Country[]{NAfrica, Turkey, Iran,
            NEAfrica};
        Iran.adjacentCountries = new Country[]{SWRussia, Turkey, Arabia,
            CAsia, SAsia};
        CAsia.adjacentCountries = new Country[]{Iran, Kazakhstan, SWChina,
            SAsia};
        Kazakhstan.adjacentCountries = new Country[]{SWRussia, Ural,
            SSiberia, CAsia, NWChina, SWChina};
        Mongolia.adjacentCountries = new Country[]{SSiberia, SERussia,
            NWChina, NEChina};
        NWChina.adjacentCountries = new Country[]{SSiberia, Kazakhstan,
            Mongolia, SWChina, NEChina};
        SWChina.adjacentCountries = new Country[]{CAsia, Kazakhstan, NWChina,
            SEChina, SAsia, SEAsia};
        NEChina.adjacentCountries = new Country[]{SERussia, Mongolia,
            NWChina, SEChina, Korea};
        SEChina.adjacentCountries = new Country[]{SWChina, NEChina, SEAsia,
            Japan, Korea};
        Korea.adjacentCountries = new Country[]{SERussia, NEChina, SEChina,
            Japan};
        Japan.adjacentCountries = new Country[]{Hawaii, NewGuinea, SEChina,
            Korea, SERussia, ERussia};
        SAsia.adjacentCountries = new Country[]{Iran, CAsia, SWChina, SEAsia};
        SEAsia.adjacentCountries = new Country[]{SWChina, SEChina, SAsia,
            Indonesia};
        Indonesia.adjacentCountries = new Country[]{SEAsia, NAustralia,
            NewGuinea, WAustralia};
        WAustralia.adjacentCountries = new Country[]{NAustralia, SAustralia,
            Madagascar, Indonesia};
        NAustralia.adjacentCountries = new Country[]{WAustralia, SAustralia,
            NewGuinea, Indonesia};
        SAustralia.adjacentCountries = new Country[]{WAustralia, NAustralia,
            NewZealand, Tasmania};
        Tasmania.adjacentCountries = new Country[]{SAustralia, NewZealand};
        NewGuinea.adjacentCountries = new Country[]{NewZealand, NAustralia,
            Indonesia, Japan};
        NewZealand.adjacentCountries = new Country[]{Peru, SAustralia,
            NewGuinea};
        // -Country Bomb/Nuclear Weapon Range Lists-
        /*
         * Each country's list of countries it can hit with bombs and nuclear
         * weapons
         */
        Yukon.bombingRangeCountries = new Country[]{NWCanada,
            BritishColombia, Alaska, CCanada, WUnitedStates};
        NWCanada.bombingRangeCountries = new Country[]{Yukon, Nunavut,
            CCanada, BritishColombia, ECanada, Alaska, WUnitedStates,
            CUnitedStates};
        Nunavut.bombingRangeCountries = new Country[]{NWCanada, CCanada,
            ECanada, WGreenland, Yukon, BritishColombia, EGreenland,
            SGreenland, WUnitedStates, CUnitedStates, NUnitedStates};
        BritishColombia.bombingRangeCountries = new Country[]{Yukon, CCanada,
            Alaska, WUnitedStates, NWCanada, Hawaii, CUnitedStates,
            NCentralAmerica};
        CCanada.bombingRangeCountries = new Country[]{NWCanada, Nunavut,
            BritishColombia, ECanada, WUnitedStates, CUnitedStates, Yukon,
            Alaska, Hawaii, SUnitedStates, NUnitedStates, NCentralAmerica};
        ECanada.bombingRangeCountries = new Country[]{CCanada, CUnitedStates,
            NUnitedStates, SGreenland, Nunavut, NWCanada, BritishColombia,
            WGreenland, WUnitedStates, SUnitedStates, NCentralAmerica,
            SCentralAmerica, Caribbean, Iceland};
        WGreenland.bombingRangeCountries = new Country[]{EGreenland,
            SGreenland, Nunavut, ECanada, Britain, Iceland};
        EGreenland.bombingRangeCountries = new Country[]{WGreenland,
            SGreenland, Scandinavia, Britain, Iceland};
        SGreenland.bombingRangeCountries = new Country[]{WGreenland,
            EGreenland, Britain, Iceland, ECanada, NUnitedStates};
        Alaska.bombingRangeCountries = new Country[]{Yukon, BritishColombia,
            ERussia, Hawaii, NWCanada, CCanada, WUnitedStates};
        Hawaii.bombingRangeCountries = new Country[]{Japan, WUnitedStates,
            Alaska, BritishColombia, NCentralAmerica};
        WUnitedStates.bombingRangeCountries = new Country[]{BritishColombia,
            CCanada, CUnitedStates, SUnitedStates, NCentralAmerica, Hawaii,
            Yukon, NWCanada, Alaska, NUnitedStates, SCentralAmerica};
        CUnitedStates.bombingRangeCountries = new Country[]{CCanada, ECanada,
            WUnitedStates, SUnitedStates, NUnitedStates, NWCanada,
            BritishColombia, NCentralAmerica, SCentralAmerica, Caribbean};
        SUnitedStates.bombingRangeCountries = new Country[]{WUnitedStates,
            CUnitedStates, NUnitedStates, NCentralAmerica, Caribbean,
            BritishColombia, CCanada, ECanada, SCentralAmerica,
            NSouthAmerica, Peru};
        NUnitedStates.bombingRangeCountries = new Country[]{ECanada,
            CUnitedStates, SUnitedStates, CCanada, WUnitedStates,
            NCentralAmerica, SCentralAmerica, Caribbean};
        NCentralAmerica.bombingRangeCountries = new Country[]{WUnitedStates,
            SUnitedStates, SCentralAmerica, BritishColombia, CCanada,
            Hawaii, CUnitedStates, NUnitedStates, Caribbean, NSouthAmerica,
            Peru};
        SCentralAmerica.bombingRangeCountries = new Country[]{
            NCentralAmerica, NSouthAmerica, Caribbean, WUnitedStates,
            CUnitedStates, SUnitedStates, NUnitedStates, Peru, NBrazil};
        Caribbean.bombingRangeCountries = new Country[]{NSouthAmerica,
            SCentralAmerica, SUnitedStates, CUnitedStates, NUnitedStates,
            NCentralAmerica, Peru, NBrazil, SBrazil};
        NSouthAmerica.bombingRangeCountries = new Country[]{SCentralAmerica,
            Peru, NBrazil, Caribbean, SUnitedStates, NCentralAmerica,
            SBrazil, Chile, SSouthAmerica};
        Peru.bombingRangeCountries = new Country[]{NSouthAmerica, NBrazil,
            SBrazil, Chile, SSouthAmerica, NewZealand, SCentralAmerica,
            Caribbean};
        NBrazil.bombingRangeCountries = new Country[]{NSouthAmerica, Peru,
            SBrazil, WAfrica, SCentralAmerica, Caribbean, Chile,
            SSouthAmerica};
        SBrazil.bombingRangeCountries = new Country[]{Peru, NBrazil,
            SSouthAmerica, SCentralAmerica, Caribbean, NSouthAmerica, Chile};
        Chile.bombingRangeCountries = new Country[]{Peru, SSouthAmerica,
            NSouthAmerica, NBrazil, SBrazil};
        SSouthAmerica.bombingRangeCountries = new Country[]{Peru, SBrazil,
            Chile, SCentralAmerica, Caribbean, NSouthAmerica, NBrazil};
        Britain.bombingRangeCountries = new Country[]{Iceland, Scandinavia,
            SGreenland, WEurope, CEurope, SEurope, NWAfrica, Algeria};
        Scandinavia.bombingRangeCountries = new Country[]{Finland, CEurope,
            Iceland, Britain, EGreenland, WEurope, SEurope, EEurope,
            NWRussia, SWRussia, Turkey};
        Iceland.bombingRangeCountries = new Country[]{Scandinavia, Britain,
            SGreenland, WGreenland, EGreenland, WEurope};
        Finland.bombingRangeCountries = new Country[]{Scandinavia, EEurope,
            NWRussia, Britain, WEurope, CEurope, SEurope, SWRussia, Turkey};
        WEurope.bombingRangeCountries = new Country[]{CEurope, SEurope,
            NWAfrica, Britain, Scandinavia, Iceland, Finland, EEurope,
            Algeria, NAfrica, WAfrica, Turkey};
        CEurope.bombingRangeCountries = new Country[]{Scandinavia, WEurope,
            SEurope, EEurope, Britain, Iceland, Finland, NWRussia, SWRussia,
            NWAfrica, Algeria, NAfrica, Turkey, Arabia, Iran};
        SEurope.bombingRangeCountries = new Country[]{WEurope, CEurope,
            EEurope, Turkey, NAfrica, Britain, Scandinavia, Finland,
            NWRussia, SWRussia, NWAfrica, Algeria, WAfrica, NEAfrica,
            NCAfrica, Arabia, Iran, CAsia, Kazakhstan};
        EEurope.bombingRangeCountries = new Country[]{Finland, CEurope,
            SEurope, NWRussia, SWRussia, Turkey, Scandinavia, WEurope,
            Algeria, NAfrica, NEAfrica, Arabia, Iran, CAsia, Kazakhstan};
        NWRussia.bombingRangeCountries = new Country[]{Finland, EEurope,
            SWRussia, Ural, Scandinavia, CEurope, SEurope, NSiberia,
            SSiberia, Turkey, Iran, CAsia, Kazakhstan};
        SWRussia.bombingRangeCountries = new Country[]{EEurope, NWRussia,
            Ural, Turkey, Iran, Kazakhstan, Scandinavia, Finland, CEurope,
            SEurope, NAfrica, NEAfrica, SSiberia, Arabia, CAsia, NWChina,
            SAsia};
        NWAfrica.bombingRangeCountries = new Country[]{WEurope, Algeria,
            WAfrica, Britain, CEurope, SEurope, NAfrica, NEAfrica, NCAfrica};
        Algeria.bombingRangeCountries = new Country[]{NWAfrica, NAfrica,
            WAfrica, Britain, WEurope, CEurope, SEurope, EEurope, NEAfrica,
            NCAfrica, SCAfrica, Turkey};
        NAfrica.bombingRangeCountries = new Country[]{Algeria, WAfrica,
            NEAfrica, Arabia, SEurope, Britain, WEurope, CEurope, EEurope,
            SWRussia, NWAfrica, NCAfrica, EAfrica, SCAfrica, Turkey, Iran,
            CAsia};
        WAfrica.bombingRangeCountries = new Country[]{NWAfrica, Algeria,
            NAfrica, NEAfrica, NCAfrica, NBrazil, WEurope, CEurope, SEurope,
            EAfrica, SEAfrica, SCAfrica, Turkey, Arabia};
        NEAfrica.bombingRangeCountries = new Country[]{NAfrica, WAfrica,
            NCAfrica, EAfrica, Arabia, WEurope, CEurope, SEurope, EEurope,
            NWAfrica, Algeria, SEAfrica, SCAfrica, Madagascar, SAfrica,
            Turkey, Iran, CAsia};
        NCAfrica.bombingRangeCountries = new Country[]{WAfrica, NEAfrica,
            EAfrica, SCAfrica, SEurope, NWAfrica, Algeria, NAfrica,
            SEAfrica, Madagascar, SAfrica, Arabia};
        EAfrica.bombingRangeCountries = new Country[]{NEAfrica, NCAfrica,
            SEAfrica, SCAfrica, SEurope, Algeria, NAfrica, WAfrica,
            Madagascar, SAfrica, Turkey, Arabia, Iran, CAsia, SAsia};
        SEAfrica.bombingRangeCountries = new Country[]{EAfrica, SCAfrica,
            SAfrica, NEAfrica, NCAfrica, Madagascar};
        SCAfrica.bombingRangeCountries = new Country[]{NCAfrica, EAfrica,
            SEAfrica, SAfrica, Algeria, NAfrica, WAfrica, NEAfrica,
            Madagascar, Arabia};
        Madagascar.bombingRangeCountries = new Country[]{WAustralia,
            SEAfrica, NEAfrica, EAfrica, SCAfrica, SAfrica};
        SAfrica.bombingRangeCountries = new Country[]{SEAfrica, SCAfrica,
            NCAfrica, EAfrica, Madagascar};
        Ural.bombingRangeCountries = new Country[]{NWRussia, SWRussia,
            NSiberia, SSiberia, Kazakhstan, EEurope, Turkey, Iran, CAsia,
            Mongolia, NWChina, SWChina, SAsia};
        NSiberia.bombingRangeCountries = new Country[]{Ural, SSiberia, Sakha,
            SERussia, CAsia, Kazakhstan, Mongolia, NWChina, SWChina,
            NEChina, Korea};
        SSiberia.bombingRangeCountries = new Country[]{Ural, NSiberia, Sakha,
            SERussia, Kazakhstan, Mongolia, NWChina, NWRussia, SWRussia,
            Iran, CAsia, SWChina, NEChina, SEChina, Korea, SAsia};
        Sakha.bombingRangeCountries = new Country[]{NSiberia, SSiberia,
            SERussia, ERussia, Mongolia, NWChina, NEChina, Korea, Japan};
        SERussia.bombingRangeCountries = new Country[]{SSiberia, Sakha,
            ERussia, Mongolia, NEChina, Korea, Japan, NSiberia, NWChina,
            SWChina, SEChina};
        ERussia.bombingRangeCountries = new Country[]{Sakha, SERussia,
            Alaska, Japan, NEChina, Korea};
        Turkey.bombingRangeCountries = new Country[]{SEurope, SWRussia,
            Arabia, Iran, EEurope, CEurope, Algeria, NAfrica, NEAfrica,
            EAfrica, CAsia, Kazakhstan, SAsia};
        Arabia.bombingRangeCountries = new Country[]{NAfrica, Turkey, Iran,
            NEAfrica, CEurope, SEurope, EEurope, SWRussia, NCAfrica,
            EAfrica, SEAfrica, SCAfrica, Madagascar, CAsia, Kazakhstan,
            SAsia};
        Iran.bombingRangeCountries = new Country[]{SWRussia, Turkey, Arabia,
            CAsia, SAsia, SEurope, EEurope, NAfrica, NEAfrica, EAfrica,
            Kazakhstan, NWChina, SWChina};
        CAsia.bombingRangeCountries = new Country[]{Iran, Kazakhstan,
            SWChina, SAsia, SEurope, EEurope, NWRussia, SWRussia, NAfrica,
            Ural, SSiberia, Turkey, Arabia, Mongolia, NWChina};
        Kazakhstan.bombingRangeCountries = new Country[]{SWRussia, Ural,
            SSiberia, CAsia, NWChina, SWChina, Finland, SEurope, EEurope,
            NWRussia, NAfrica, Turkey, Arabia, Iran, Mongolia, SAsia};
        Mongolia.bombingRangeCountries = new Country[]{SSiberia, SERussia,
            NWChina, NEChina, SWRussia, Ural, NSiberia, Sakha, Iran, CAsia,
            Kazakhstan, SWChina, SEChina, Korea, Japan, SAsia, SEAsia};
        NWChina.bombingRangeCountries = new Country[]{SSiberia, Kazakhstan,
            Mongolia, SWChina, NEChina, SWRussia, Ural, SERussia, Iran,
            CAsia, SEChina, Korea, Japan, SAsia, SEAsia, Indonesia};
        SWChina.bombingRangeCountries = new Country[]{CAsia, Kazakhstan,
            NWChina, SEChina, SAsia, SEAsia, SWRussia, Ural, SSiberia,
            SERussia, Turkey, Arabia, Iran, Mongolia, NEChina, Korea, Japan,
            Indonesia};
        NEChina.bombingRangeCountries = new Country[]{SERussia, Mongolia,
            NWChina, SEChina, Korea, NSiberia, SSiberia, Sakha, SWChina,
            Japan, SAsia, SEAsia, Indonesia};
        SEChina.bombingRangeCountries = new Country[]{SWChina, NEChina,
            SEAsia, Japan, Korea, SSiberia, SERussia, Mongolia, NWChina,
            SAsia, Indonesia, NewGuinea};
        Korea.bombingRangeCountries = new Country[]{SERussia, NEChina,
            SEChina, Japan, Sakha, Mongolia, SEAsia};
        Japan.bombingRangeCountries = new Country[]{Hawaii, NewGuinea,
            SEChina, Korea, SERussia, ERussia, Sakha, NEChina, SEAsia,
            Indonesia};
        SAsia.bombingRangeCountries = new Country[]{Iran, CAsia, SWChina,
            SEAsia, SWRussia, EAfrica, SSiberia, Turkey, Arabia, Kazakhstan,
            Mongolia, NWChina, NEChina, SEChina, Indonesia};
        SEAsia.bombingRangeCountries = new Country[]{SWChina, SEChina, SAsia,
            Indonesia, CAsia, Mongolia, NWChina, NEChina, Korea, Japan,
            WAustralia, NAustralia, NewGuinea};
        Indonesia.bombingRangeCountries = new Country[]{SEAsia, NAustralia,
            NewGuinea, WAustralia, NWChina, SWChina, SEChina, Japan, SAsia,
            SAustralia};
        WAustralia.bombingRangeCountries = new Country[]{NAustralia,
            SAustralia, Madagascar, Indonesia, SEAsia, Tasmania, NewGuinea};
        NAustralia.bombingRangeCountries = new Country[]{WAustralia,
            SAustralia, NewGuinea, Indonesia, SEAsia, Tasmania, NewZealand};
        SAustralia.bombingRangeCountries = new Country[]{WAustralia,
            NAustralia, NewZealand, Tasmania, Indonesia, NewGuinea};
        Tasmania.bombingRangeCountries = new Country[]{SAustralia,
            NewZealand, WAustralia, NAustralia};
        NewGuinea.bombingRangeCountries = new Country[]{NewZealand,
            NAustralia, Indonesia, Japan, SEChina, Korea, SEAsia,
            WAustralia, SAustralia};
        NewZealand.bombingRangeCountries = new Country[]{Peru, SAustralia,
            NewGuinea, Tasmania};

        // --Country List--
        // Copying each continent into countries list
        System.arraycopy(asia, 0, countries, 0, 21);
        System.arraycopy(oceania, 0, countries, 21, 6);
        System.arraycopy(northAmerica, 0, countries, 27, 18);
        System.arraycopy(southAmerica, 0, countries, 45, 6);
        System.arraycopy(africa, 0, countries, 51, 11);
        System.arraycopy(europe, 0, countries, 62, 10);

        // --Country Owners--
        // Every country is neutral to begin
        for(Country country : countries){
            country.owner = playerNeutral;
        }

        // --Death Total--
        long deathTotal = 0;

        // --Screen Setup--
        clearScreen();
        // Initial Introduction
        System.out.println(ANSI_RESET + """
            Welcome to Kingdom of War - Global Conquest!
            Before the game begins, you must ensure your
            screen is large enough. Please use a large
            monitor and enter fullscreen mode.""");
        delayedClearScreen();
        clearScreen();
        // Printing Placeholder Map to Show Map Size
        for(int i = 0; i < 39; i++){
            System.out.print("|");
            for(int ii = 0; ii < 147; ii++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println("""
            You should see many rows, each starting with a
            pipe (\"|\"), and many dashes. No row should break
            or start without a pipe. If these conditions are
            not met, your screen is not large enough to play
            this game. To fix this, find a larger screen, make
            sure you're in fullscreen mode, and reduce your
            zoom level  if needed. Your screen does NOT have
            to be tall enough to see everything without
            scrolling.""");
        delayedClearScreen();

        // --Number Formatting Setup--
        /*
         * Different people use different ways to format numbers, this lets
         * the user pick their preference to be used throughout the game
         */
        System.out.println("""
            Now that your screen is ready, please choose how
            you would like large numbers and decimals to be
            formatted. Numbers are formatted differently 
            around the world, so please chose your preference.
            First, what would you like to separate groups of
            three in large numbers? Note that "_" here
            represents a space, but will not actually be used.
            [1] ,
            [2] ,_
            [3] .
            [4] ._
            [5] _""");
        switch((int) getNum(1, 5)){
            case 1:
                numSeparator = ",";
            case 2:
                numSeparator = ", ";
            case 3:
                numSeparator = ".";
            case 4:
                numSeparator = ". ";
            case 5:
                numSeparator = " ";
        }
        System.out.println("""
            Next, what would you like as a decimal?
            [1] ,
            [2] .""");
        if(getNum(1, 2) == 1){
            numDecimal = ".";
        }else{
            numDecimal = ",";
        }
        if(numDecimal.equals(numSeparator)){
            System.out.println("""
                Unfortunately, you cannot have both of these be
                the same, so your decimal has been changed to "*".""");
            numDecimal = "*";
        }
        clearScreen();

        // WEBSITE LINK
        // Link to Kingdom of War - Global Conquest website
        System.out.println("""
            Here is this game's website.
            NOT AVAILABLE
            This website has all the game's rules, so it is
            suggested that you open it.""");
        delayedClearScreen();

        // INTRO SCREEN
        // Prints intro screen, which is a certain map
        String[] lines = readFile("Logo.txt").split("\n");
        for(String line : lines){
            String[] pixels = line.split(" ");
            for(String item : pixels){
                String[] pixel = item.split("\\|");
                System.out.print("\u001b[48;5;" + pixel[0] +
                    "m\u001b[38;5;" + pixel[1] + "m▄");
            }
            System.out.println(ANSI_RESET);
        }
        delayedClearScreen();

        // PLAYER SETUP
        System.out.println("""
            Select an option begin the game.
            Start new game starts a new, normal game. Load
            game code lets you load a long (saved by you
            previously) or short (copied from website) game
            code. Create custom game lets you create a custom
            game with modified army numbers, players starting
            with more than one country, etc.
            [1] Start new game
            [2] Load game code
            [3] Create custom game""");
        int numPlayers = 0;
        int turnNum = 1;
        int baseGain;
        baseGain = 200;
        switch((int) getNum(1, 3)){
            case 1:
                // --Start New Game--
                // -Player Creation-
                clearScreen();
                // Getting number of players
                System.out.println("How many players are there (max. 6)?");
                // Initial Creation
                numPlayers = (int) getNum(2, 6);
                for(int i = 0; i < numPlayers; i++){
                    players.add(new Player( /* false, Removed until v2.0.0 */
                        "", '-'));
                }
                ArrayList<String> availableColors = new ArrayList<String>(
                    Arrays.asList("Red", "Orange", "Yellow", "Green", "Blue",
                    "Purple", "Pink", "Teal", "Black"));
                ArrayList<Player> playersList = getPlayers(false, false);
                for(Player player : playersList){
                    clearScreen();
                    // Player's Name
                    System.out.println("Player " +
                        (playersList.indexOf(player) + 1) + """
                        
                        What is this player's name?
                        Names cannot contain pipes (| symbol).""");
                    player.name = scanner.nextLine().replace("|", "");
                    // Is Player a Bot
                    /*System.out.println("""
                        \nIs this player a bot (controlled by the game)?
                        [1] Yes
                        [2] No""");
                    if(getNum(1, 2) == 1){
                        player.bot = true;
                    } Removed until v2.0.0 */
                    // Player's Color (for Text and Map Printing)
                    System.out.println("\nWhat is this player's color?");
                    for(String color : availableColors){
                        System.out.println("[" +
                            (availableColors.indexOf(color) + 1) +
                            "] " + color);
                    }
                    String color = availableColors.get((int)
                        getNum(1, availableColors.size()) - 1);
                    switch(color){
                        case "Red":
                            player.color = RED_COLOR_LIST; // Map
                            player.textColor = "\u001b[38;5;160;1m"; // Text
                            break;
                        case "Orange":
                            player.color = ORANGE_COLOR_LIST; // Map
                            player.textColor = "\u001b[38;5;202;1m"; // Text
                            break;
                        case "Yellow":
                            player.color = YELLOW_COLOR_LIST;
                            player.textColor = "\u001b[38;5;227;1m";
                            break;
                        case "Green":
                            player.color = GREEN_COLOR_LIST;
                            player.textColor = "\u001b[38;5;40;1m";
                            break;
                        case "Blue":
                            player.color = BLUE_COLOR_LIST;
                            player.textColor = "\u001b[38;5;45;1m";
                            break;
                        case "Purple":
                            player.color = PURPLE_COLOR_LIST;
                            player.textColor = "\u001b[38;5;57;1m";
                            break;
                        case "Pink":
                            player.color = PINK_COLOR_LIST;
                            player.textColor = "\u001b[38;5;213;1m";
                            break;
                        case "Teal":
                            player.color = TEAL_COLOR_LIST;
                            player.textColor = "\u001b[38;5;29;1m";
                            break;
                        case "Black":
                            player.color = BLACK_COLOR_LIST;
                            player.textColor = "\u001b[38;5;234;1m";
                            break;
                    }
                    availableColors.remove(color);
                }
                clearScreen();
                // -Country Choosing-
                ArrayList<Country> availableCountries =
                    new ArrayList<Country>(Arrays.asList(countries));
                System.out.println("""
                    Each player must now choose a country to start in.
                    How would you like countries to be chosen?
                    [1] Players are randomly assigned countries
                    [2] Players choose their countries""");
                if(getNum(1, 2) == 1){
                    // Randomly Assigning Countries
                    clearScreen();
                    for(Player player : getPlayers(false, false)){
                        Country country = availableCountries.get(
                            random.nextInt(availableCountries.size()));
                        country.owner = player;
                        availableCountries.remove(country);
                        for(Country adjacentCountry :
                        country.adjacentCountries){
                            // Players cannot have adjacent countries
                            availableCountries.remove(adjacentCountry);
                        }
                        System.out.println(player.getColoredName() + " got " +
                            country.getColoredName() +
                            " as their country.");
                    }
                    delayedClearScreen();
                }else{
                    // Players Chose Their Country
                    clearScreen();
                    for(Player player :
                    randomizeList(getPlayers(false, false))){
                        // Print Map to Show Options
                        printMap(1);
                        System.out.println(player.getColoredName() + """
                            , please choose a country on this map.
                            You cannot chose a country that has already
                            been chosen (is not gray) or a country next
                            to one that has already been chosen.""");
                            /*if(player.bot){
                                // Player is a Bot
                                /*
                                 * Methodology:
                                 * Bot splits map into a number of regions based
                                 * on number of players, chooses fairly central
                                 * country in region.
                                 *//*
                                switch(numPlayers){
                                    case 2:
                                        // There Are Two Players
                                        Country[] northwestCountries =
                                            new Country[30];
                                        System.arraycopy(northAmerica, 0,
                                            northwestCountries, 0, 13);
                                        System.arraycopy(southAmerica, 0,
                                            northwestCountries, 13, 5);
                                        System.arraycopy(europe, 0,
                                            northwestCountries, 18, 12);
                                        boolean northwestOccupied = false;
                                        for(Country country : northwestCountries){
                                            if(country.owner != playerNeutral){
                                                northwestOccupied = true;
                                                break;
                                            }
                                        }
                                        if(northwestOccupied){
                                            india.owner = player;
                                        }else{
                                            atlanticAmerica.owner = player;
                                        }
                                        break;
                                    case 3:
                                        // There Are Three Players
                                        Country[] westCountries = new Country[18];
                                        System.arraycopy(northAmerica, 0,
                                            westCountries, 0, 13);
                                        System.arraycopy(southAmerica, 0,
                                            westCountries, 13, 5);
                                        Country[] centralCountries =
                                            new Country[22];
                                        System.arraycopy(europe, 0,
                                            centralCountries, 0, 12);
                                        System.arraycopy(africa, 0,
                                            centralCountries, 12, 10);
                                        boolean westOccupied = false;
                                        boolean centralOccupied = false;
                                        for(Country country : westCountries){
                                            if(country.owner != playerNeutral){
                                                westOccupied = true;
                                                break;
                                            }
                                        }
                                        for(Country country : centralCountries){
                                            if(country.owner != playerNeutral){
                                                centralOccupied = true;
                                                break;
                                            }
                                        }
                                        if(westOccupied){
                                            if(centralOccupied){
                                                southernChina.owner = player;
                                            }else{
                                                italy.owner = player;
                                            }
                                        }else{
                                            mexico.owner = player;
                                        }
                                        break;
                                    case 4:
                                        // There Are Four Players
                                        Country[] eastCountries = new Country[20];
                                        System.arraycopy(asia, 0,
                                            eastCountries, 0, 16);
                                        System.arraycopy(oceania, 0,
                                            eastCountries, 16, 4);
                                        Country[] southAmericaAfrica =
                                            new Country[15];
                                        System.arraycopy(southAmerica, 0,
                                            southAmericaAfrica, 0, 5);
                                        System.arraycopy(africa, 0,
                                            southAmericaAfrica, 5, 10);
                                        boolean eastOccupied = false;
                                        boolean southAmericaAfricaOccupied =
                                            false;
                                        boolean europeOccupied = false;
                                        for(Country country : eastCountries){
                                            if(country.owner != playerNeutral){
                                                eastOccupied = true;
                                                break;
                                            }
                                        }
                                        for(Country country : southAmericaAfrica){
                                            if(country.owner != playerNeutral){
                                                southAmericaAfricaOccupied = true;
                                                break;
                                            }
                                        }
                                        for(Country country : europe){
                                            if(country.owner != playerNeutral){
                                                europeOccupied = true;
                                                break;
                                            }
                                        }
                                        if(eastOccupied){
                                            if(southAmericaAfricaOccupied){
                                                if(europeOccupied){
                                                    middleAmerica.owner = player;
                                                }else{
                                                    germany.owner = player;
                                                }
                                            }else{
                                                brazil.owner = player;
                                            }
                                        }else{
                                            southernChina.owner = player;
                                        }
                                        break;
                                    case 5:
                                        // There Are Five Players
                                        Country[] southAmericaOceania =
                                            new Country[9];
                                        System.arraycopy(southAmerica, 0,
                                            southAmericaOceania, 0, 5);
                                        System.arraycopy(oceania, 0,
                                            southAmericaOceania, 5, 4);
                                        boolean asiaOccupied = false;
                                        boolean africaOccupied = false;
                                        europeOccupied = false;
                                        boolean southAmericaOceaniaOccupied =
                                            false;
                                        for(Country country : asia){
                                            if(country.owner != playerNeutral){
                                                asiaOccupied = true;
                                                break;
                                            }
                                        }
                                        for(Country country : africa){
                                            if(country.owner != playerNeutral){
                                                africaOccupied = true;
                                                break;
                                            }
                                        }
                                        for(Country country : europe){
                                            if(country.owner != playerNeutral){
                                                europeOccupied = true;
                                                break;
                                            }
                                        }
                                        for(Country country :
                                        southAmericaOceania){
                                            if(country.owner != playerNeutral){
                                                southAmericaOceaniaOccupied =
                                                    true;
                                                break;
                                            }
                                        }
                                        if(asiaOccupied){
                                            if(africaOccupied){
                                                if(europeOccupied){
                                                    if(southAmericaOceaniaOccupied
                                                    ){
                                                        middleAmerica.owner =
                                                            player;
                                                    }else{
                                                        peru.owner = player;
                                                    }
                                                }else{
                                                    germany.owner = player;
                                                }
                                            }else{
                                                centralAfrica.owner = player;
                                            }
                                        }else{
                                            mongolia.owner = player;
                                        }
                                        break;
                                    case 6:
                                        // There Are Six Players
                                        europeOccupied = false;
                                        africaOccupied = false;
                                        boolean northAmericaOccupied = false;
                                        asiaOccupied = false;
                                        boolean southAmericaOccupied = false;
                                        for(Country country : europe){
                                            if(country.owner != playerNeutral){
                                                europeOccupied = true;
                                                break;
                                            }
                                        }
                                        for(Country country : africa){
                                            if(country.owner != playerNeutral){
                                                africaOccupied = true;
                                                break;
                                            }
                                        }
                                        for(Country country : northAmerica){
                                            if(country.owner != playerNeutral){
                                                northAmericaOccupied = true;
                                                break;
                                            }
                                        }
                                        for(Country country : asia){
                                            if(country.owner != playerNeutral){
                                                asiaOccupied = true;
                                                break;
                                            }
                                        }
                                        for(Country country : southAmerica){
                                            if(country.owner != playerNeutral){
                                                southAmericaOccupied = true;
                                                break;
                                            }
                                        }
                                        if(europeOccupied){
                                            if(africaOccupied){
                                                if(northAmericaOccupied){
                                                    if(asiaOccupied){
                                                        if(southAmericaOccupied){
                                                            queensland.owner =
                                                                player;
                                                        }else{
                                                            brazil.owner = player;
                                                        }
                                                    }else{
                                                        mongolia.owner = player;
                                                    }
                                                }else{
                                                    middleAmerica.owner = player;
                                                }
                                            }else{
                                                middleAfrica.owner = player;
                                            }
                                        }else{
                                            germany.owner = player;
                                        }
                                        break;
                                }
                                System.out.println(player.getColoredName() +
                                    " chose " +
                                    player.getCountries()[0].getColoredName() +
                                    ANSI_RESET + " as their country.\n");
                                delayedClearScreen();
                            }else{ Removed until v2.0.0 */
                                // Player Chooses
                                Country country = getCountry(availableCountries);
                                country.owner = player;
                                clearScreen();
                            //} Removed until v2.0.0
                        /*
                         * Remove Chosen Country and Its Adjacent Countries
                         * From Available Countries
                         */
                        country = player.getCountries()[0];
                        availableCountries.remove(country);
                        for(Country adjacentCountry :
                        country.adjacentCountries){
                            availableCountries.remove(adjacentCountry);
                        }
                    }
                }
                break;
            case 2:
                // --Load Game Code--
                clearScreen();
                /*
                 * Used later to decide whether the player's status as a
                 * human/bot can be changed
                 */
                //boolean botChangeable = false; Removed until v2.0.0
                // -Long or Short Game Code-
                System.out.println("""
                    Would you like to load a long or short game code?
                    Long game codes are created when you save a game
                    yourself, while short game codes for a limited
                    number of setups can be obtained from the website.
                    [1] Long game code
                    [2] Short game code""");
                String gameCode = "";
                if(getNum(1, 2) == 1){
                    // Long Game Code
                    clearScreen();
                    System.out.println("""
                        Please paste the entire game code here.
                        The game code should end with \"DONE\".""");
                    // Reading Game Code
                    while(true){
                        String line = scanner.nextLine();
                        gameCode += line;
                        if(line.endsWith("DONE")){
                            // End of Game Code
                            break;
                        }
                    }
                    // Can Player's Status as Human/Bot be Changed
                    /*clearScreen();
                    System.out.println("""
                        Every player in this game code is either a human
                        or a bot. Would you like the option to change each
                        player's status as human/bot? This could be useful
                        if you have more or less players than when this
                        game code was created.
                        [1] Yes I would like their status to be changeable
                        [2] No I would not like their status to be
                            changeable""");
                    if(getNum(1, 2) == 1){
                        botChangeable = true;
                    } Removed until v2.0.0 */
                }else{
                    // Short Game Code
                    clearScreen();
                    while(true){
                        System.out.println("Please paste your short code.");
                        String shortCode = scanner.nextLine();
                        String[] codes =
                            readFile("Short Codes.txt").split("\n");
                        for(int i = 0; i < codes.length / 2; i++){
                            if(codes[i * 2].equals(shortCode)){
                                gameCode = codes[i * 2 + 1];
                                break;
                            }
                        }
                        if(gameCode.equals("")){
                            System.out.println(RED_TEXT + """
                                This short code could not be found.
                                Short codes:""" +
                                ANSI_RESET);
                            for(int i = 0; i < codes.length / 2; i++){
                                System.out.println(codes[i * 2]);
                            }
                            System.out.println();
                        }else{
                            break;
                        }
                    }
                }
                clearScreen();
                // Loading Game From Game Code
                String[] gameCodes = gameCode.replace("\n", "").split("\\|");
                // Keeps Track of Next Game Code
                int i = 0;
                // Number of Players and Current Turn Number
                numPlayers = Integer.parseInt(gameCodes[i++]);
                turnNum = Integer.parseInt(gameCodes[i++]);
                // Death Total
                deathTotal = Integer.parseInt(gameCodes[i++]);
                // Base Gain
                baseGain = Integer.parseInt(gameCodes[i++]);
                // Creating Players
                for(i = 0; i < numPlayers; i++){
                    players.add(new Player( /* false, Removed until v2.0.0 */
                        "", '-'));
                }
                // Player Data
                playersList = getPlayers(false, false);
                for(Player player : playersList){
                    // Player's Name
                    player.name = gameCodes[i++].replace("|", "");
                    // Game codes from the website have no player names
                    while(player.name.equals("")){
                        System.out.println("Player " +
                            (playersList.indexOf(player) + 1) + """
                             does not appear to have a name.
                            What is their name?""");
                        player.name = scanner.nextLine().replace("|", "");
                        clearScreen();
                    }
                    i++;
                    // Is Player a Bot
                    /*String isBot = gameCodes[i++];
                    if(isBot.equals("m")){
                        // Player Might be a Bot
                        System.out.println("Player " +
                            (playersList.indexOf(player) + 1) + """
                             is not defined as human or bot.
                            Are they a bot?
                            [1] Yes
                            [2] No""");
                        if(getNum(1, 2) == 1){
                            player.bot = true;
                        }
                        clearScreen();
                    }else{
                        if(isBot.equals("y")){
                            // Player is a Bot
                            player.bot = true;
                        }
                        if(botChangeable){
                            // Player's Status as a Human/Bot can be Changed
                            System.out.print("Player " +
                                (playersList.indexOf(player) + 1) + " is a ");
                            if(player.bot){
                                System.out.println("bot.");
                            }else{
                                System.out.println("human.");
                            }
                            System.out.println("""
                                Would you like to change this?
                                [1] Yes
                                [2] No""");
                            if(getNum(1, 2) == 1){
                                // Player Becomes Opposite
                                player.bot = ! player.bot;
                                System.out.println("""
                                    \nWould you like to change their name?
                                    Their current name is""" + " " +
                                    player.name + """
                                    .
                                    [1] Yes
                                    [2] No""");
                                if(getNum(1, 2) == 1){
                                    System.out.print("New name: ");
                                    player.name =
                                        scanner.nextLine().replace("|", "");
                                }
                            }
                            clearScreen();
                        }
                    } Removed until v2.0.0 */
                    // Player's Color
                    switch(gameCodes[i++]){
                        case "r":
                            player.color = RED_COLOR_LIST;
                            player.textColor = "\u001b[38;5;160;1m";
                            break;
                        case "y":
                            player.color = YELLOW_COLOR_LIST;
                            player.textColor = "\u001b[38;5;227;1m";
                            break;
                        case "g":
                            player.color = GREEN_COLOR_LIST;
                            player.textColor = "\u001b[38;5;40;1m";
                            break;
                        case "b":
                            player.color = BLUE_COLOR_LIST;
                            player.textColor = "\u001b[38;5;87;1m";
                            break;
                        case "p":
                            player.color = PURPLE_COLOR_LIST;
                            player.textColor = "\u001b[38;5;57;1m";
                            break;
                        case "k":
                            player.color = PINK_COLOR_LIST;
                            player.textColor = "\u001b[38;5;213;1m";
                            break;
                    }
                    /*
                     * Player's Money, Morale, Reserve Soldiers, Bombs, and
                     * Nuclear Weapons
                     */
                    player.money = Integer.parseInt(gameCodes[i++]);
                    player.morale = Double.parseDouble(gameCodes[i++]);
                    player.reserveSoldiers = Integer.parseInt(gameCodes[i++]);
                    player.bombs = Integer.parseInt(gameCodes[i++]);
                    player.nuclearWeapons = Integer.parseInt(gameCodes[i++]);
                    String[] countryList =
                        gameCodes[i++].split("(?<=\\G...)");
                    for(String countryAbbrv : countryList){
                        for(Country country : countries){
                            if(country.abbrv.equals(countryAbbrv)){
                                country.owner = player;
                                break;
                            }
                        }
                    }
                }
                // Country Data
                for(Country country : countries){
                    // Country's Soldiers
                    country.soldiers = Integer.parseInt(gameCodes[i++]);
                }
                // Does Country Have the Virus
                String[] virusCountries =
                    gameCodes[i++].split("\"(?<=\\\\G...)\"");
                // Does Country Have Fallout
                String[] falloutCountries =
                    gameCodes[i++].split("\"(?<=\\\\G...)\"");
                for(Country country : countries){
                    if(Arrays.asList(virusCountries).contains(country.abbrv)){
                        country.virus = true;
                    }
                    if(Arrays.asList(falloutCountries)
                    .contains(country.abbrv)){
                        country.fallout = true;
                    }
                }
                // Game Code Loading Finished
                System.out.println("Game code loaded successfully.");
                delayedClearScreen();
                if(turnNum > 1){
                    // Game Statistics
                    System.out.println("""
                        Do you have game statistics data as well? If you
                        got a short code from the website, you will not.
                        If you saved a game code from a game of your own,
                        you may. If you do have a game statistics, would
                        you like to load them?
                        [1] I have game statistics and would like to load
                            them
                        [2] I do not wish to load game statistics""");
                    if(getNum(1, 2) == 1){
                        // Game Statistics
                        clearScreen();
                        System.out.println(
                            "Please paste your game statistics here."
                        );
                        // Reading Game Statistics
                        String gameStats = "";
                        while(true){
                            gameStats += scanner.nextLine() + "\n";
                            if(gameStats.endsWith("DONE\n")){
                                // End of Game Statistics
                                gameStats =
                                    gameStats.replace("DONE", "").strip();
                                break;
                            }
                        }
                        // Loading Game Statistics
                        try{
                            // Adding Game Statistics to Game Statistics File
                            PrintStream fileWriter = new PrintStream(new File
                                (FILE_DIRECTORY + "Game Statistics.txt"));
                            fileWriter.print(gameStats);
                            fileWriter.close();
                            // Game Statistics Finished Loading
                            System.out.println(
                                "\nGame statistics loaded successfully.");
                        }catch(Exception FileNotFoundException){
                            /*
                             * File Not Found Error
                             * This error does not impede the program's
                             * ability to function, but still represents
                             * a major problem.
                             */
                            clearScreen();
                            FileNotFoundException.printStackTrace();
                            System.out.println(RED_TEXT + """
                                There was a problem finding the game
                                statistics file. Please report this problem
                                to the game's creator.""" + ANSI_RESET);
                            System.exit(0);
                        }
                    }
                    delayedClearScreen();
                }
                break;
            case 3:
                // --Create Custom Game--
                clearScreen();
                // Number of Players and Current Turn Number (Always 1)
                System.out.println("How many players are there (max. 6)?");
                numPlayers = (int) getNum(2, 6);
                gameCode = numPlayers + "|1|";
                // Death Total
                System.out.println("What is the current death total" +
                    " (usually 0)?");
                deathTotal = getNum(0, 1_000_000_000);
                gameCode += deathTotal + "|";
                // Base Gain
                System.out.print("""
                    Base gain is used to control how many soldiers
                    each player will gain for certain things, like
                    controlling countries, regions, or continents. It
                    is usually set at 200, but can be changed. It is
                    recommended to make it around the population of an
                    average country in your game.
                    Base gain:""" + " ");
                baseGain = (int) getNum(1, 1_000_000_000);
                gameCode += baseGain + "|";
                // Creating Players
                for(i = 0; i < numPlayers; i++){
                    players.add(new Player(/*false, Removed until v2.0.0 */
                        "", '-'));
                }
                // Player Data
                availableColors = new ArrayList<String>(Arrays.asList(
                    "Red", "Yellow", "Green", "Blue", "Purple", "Pink"));
                playersList = getPlayers(false, false);
                for(Player player : playersList){
                    clearScreen();
                    // Player's Name
                    System.out.println("Player " +
                        (playersList.indexOf(player) + 1) + """
                        
                        What is this player's name?
                        Names cannot contain pipes (| symbol).
                        If you are making a game code, blank names
                        can be replaced when the game code is loaded.""");
                    player.name = scanner.nextLine().replace("|", "");
                    gameCode += player.name + "|";
                    // Is Player Stil Playing (Always True/Yes)
                    gameCode += "y|";
                    // Is Player a Bot
                    /*System.out.println("""
                        \nIs this player a bot (controlled by the game)?
                        [1] Yes
                        [2] No""");
                    if(getNum(1, 2) == 1){
                        player.bot = true;
                        gameCode += "y|";
                    }else{
                        gameCode += "n|";
                    } Removed until v2.0.0 */
                    // Player's Color (for Text and Map Printing)
                    System.out.println("\nWhat is this player's color?");
                    for(String color : availableColors){
                        System.out.println("[" +
                            (availableColors.indexOf(color) + 1) +
                            "] " + color);
                    }
                    String color = availableColors.get((int)
                        getNum(1, availableColors.size()) - 1);
                    switch(color){
                        case "Red":
                            player.color = RED_COLOR_LIST;
                            player.textColor = "\u001b[38;5;160;1m";
                            gameCode += "r|";
                            break;
                        case "Yellow":
                            player.color = YELLOW_COLOR_LIST;
                            player.textColor = "\u001b[38;5;227;1m";
                            gameCode += "y|";
                            break;
                        case "Green":
                            player.color = GREEN_COLOR_LIST;
                            player.textColor = "\u001b[38;5;40;1m";
                            gameCode += "g|";
                            break;
                        case "Blue":
                            player.color = BLUE_COLOR_LIST;
                            player.textColor = "\u001b[38;5;87;1m";
                            gameCode += "b|";
                            break;
                        case "Purple":
                            player.color = PURPLE_COLOR_LIST;
                            player.textColor = "\u001b[38;5;57;1m";
                            gameCode += "p|";
                            break;
                        case "Pink":
                            player.color = PINK_COLOR_LIST;
                            player.textColor = "\u001b[38;5;213;1m";
                            gameCode += "k|";
                            break;
                    }
                    availableColors.remove(color);
                    // Player's Money
                    System.out.println("""
                        \nHow much money does this player have?
                        Regular games start with $""" + formatNum(1000) +
                        ",\nbut a custom game could have any amount.");
                    player.money = getNum(0, 2_000_000_000);
                    gameCode += player.money + "|";
                    // Player's Morale
                    System.out.println("""
                        \nWhat is this player's current morale level?
                        Regular games start with 50, but custom games can
                        have any positive amount up to 100.""");
                    player.morale = getNum(0, 100);
                    gameCode += player.morale + "|";
                    // Player's Reserve Soldiers
                    System.out.println("""
                        \nHow many reserve soldiers does this player have?
                        Regular games start with 0.""");
                    player.reserveSoldiers = (int) getNum(0, 1_000_000_000);
                    gameCode += player.reserveSoldiers + "|";
                    // Player's Bombs
                    System.out.println("""
                        \nHow many bombs does this player have?
                        Regular games start with 0.""");
                    player.bombs = (int) getNum(0, 1_000_000_000);
                    gameCode += player.bombs + "|";
                    // Player's Nuclear Weapons
                    System.out.println("""
                        \nHow many nuclear weapons does this player have?
                        Regular games start with 0.""");
                    player.nuclearWeapons = (int) getNum(0, 1_000_000_000);
                    gameCode += player.nuclearWeapons + "|";
                    // Player's Countries
                    // Number of Countries
                    clearScreen();
                    printMap(1);
                    System.out.println("""
                        How many countries does this player have?
                        There are currently""" + " " +
                        playerNeutral.getCountries().length + """
                         available countries.
                        A player cannot have 0 countries.""");
                    /*
                     * Ensures a player (unless they're the last player),
                     * cannot take all remaining countries, so that the next
                     * player will not be left with 0 countries.
                     */
                    int numAvailableCountries =
                        playerNeutral.getCountries().length;
                    if(playersList.indexOf(player) < playersList.size() - 1){
                        numAvailableCountries -= 1;
                    }
                    int numCountries = (int) getNum(1, numAvailableCountries);
                    // Getting Individual Countries
                    for(i = 0; i < numCountries; i++){
                        clearScreen();
                        printMap(1);
                        System.out.print("Country " + (i + 1) + ": ");
                        Country country = getCountry(new ArrayList<Country>(
                            Arrays.asList(playerNeutral.getCountries())));
                        country.owner = player;
                        gameCode += country.abbrv;
                    }
                    gameCode += "|";
                    clearScreen();
                }
                // Country Data
                // Country's Soldiers
                System.out.println("""
                    You must now decide how many soldiers each country
                    has. There are a few different ways to do this,
                    in order to help speed things up. If countries
                    are split into different groups (neutral, non-
                    neutral, etc.), each group has a different number
                    of soldiers compared to other groups. The number
                    of soldiers in each country can also be modified
                    afterwards if you want to chose one of these but
                    have a few exceptions.
                    [1] All countries have the same number of soldiers
                    [2] All
                         -neutral countries
                         -non-neutral countries
                        have the same number of soldiers
                    [3] All
                         -neutral countries
                         -non-neutral countries bordering enemy or
                          neutral countries
                         -non-neutral countries bordering allied
                          countries only
                        have the same number of soldiers
                    [4] Each country's soldiers set individually""");
                switch((int) getNum(1, 4)){
                    case 1:
                        // All Countries
                        System.out.println(
                            "\nHow many soldiers does each country have?");
                        int num = (int) getNum(0, 1_000_000_000);
                        for(Country country : countries){
                            country.soldiers = num;
                        }
                        break;
                    case 2:
                        clearScreen();
                        // Neutral Countries
                        System.out.println("\nHow many soldiers does each" +
                            " neutral country have?");
                        num = (int) getNum(0, 1_000_000_000);
                        for(Country country : playerNeutral.getCountries()){
                            country.soldiers = num;
                        }
                        // Non-Neutral Countries
                        System.out.println("""
                            \nHow many soldiers does each non-neutral country
                            have?""");
                        num = (int) getNum(0, 1_000_000_000);
                        List<Country> nonneutralCountries = new ArrayList
                            <Country>(Arrays.asList(countries));
                        for(Country country : playerNeutral.getCountries()){
                            nonneutralCountries.remove(country);
                        }
                        for(Country country : nonneutralCountries){
                            country.soldiers = num;
                        }
                        break;
                    case 3:
                        clearScreen();
                        // Neutral Countries
                        System.out.println("\nHow many soldiers does each" +
                            " neutral country have?");
                        num = (int) getNum(0, 1_000_000_000);
                        for(Country country : playerNeutral.getCountries()){
                            country.soldiers = num;
                        }
                        // Non-Neutral Countries
                        // Does Border Enemy or Non-Neutral
                        System.out.println("""
                            \nHow many soldiers does each non-neutral country
                            that borders an enemy or neutral country have?"""
                            );
                        num = (int) getNum(0, 1_000_000_000);
                        // Does Not Border Enemy or Non-Neutral
                        System.out.println("""
                            \nHow many soldiers does each non-neutral country
                            that does not border an enemy or neutral country
                            have?""");
                        int num2 = (int) getNum(0, 1_000_000_000);
                        nonneutralCountries =
                            new ArrayList<Country>(Arrays.asList(countries));
                        for(Country country : playerNeutral.getCountries()){
                            nonneutralCountries.remove(country);
                        }
                        for(Country country : nonneutralCountries){
                            boolean bordersEnemy = false;
                            for(Country adjacentCountry :
                            country.adjacentCountries){
                                if(adjacentCountry.owner != country.owner){
                                    bordersEnemy = true;
                                    break;
                                }
                            }
                            if(bordersEnemy){
                                country.soldiers = num;
                            }else{
                                country.soldiers = num2;
                            }
                        }
                        break;
                    case 4:
                        // Each Country Individually
                        for(Country country : countries){
                            clearScreen();
                            printMap(1);
                            System.out.println(country.getColoredName() +
                                "\nOwned by: " + country.getColoredName() +
                                "\nHow many soldiers does this country have?"
                                );
                            country.soldiers = getNum(0, 1_000_000_000);
                        }
                        break;
                }
                // Changing Certain Countries' Soldiers
                while(true){
                    clearScreen();
                    printMap(1);
                    System.out.println("""
                        Are there any countries on this map you wish to
                        change in terms of number of soldiers?
                        [1] Yes
                        [2] No""");
                    if(getNum(1, 2) == 1){
                        System.out.print("Country: ");
                        Country country = getCountry(
                            new ArrayList<Country>(Arrays.asList(countries)));
                        System.out.print("Soldiers: ");
                        country.soldiers = getNum(0, 1_000_000_000);
                    }else{
                        break;
                    }
                }
                // Adding Each Country to Game Code
                for(Country country : countries){
                    gameCode += country.soldiers + "|";
                }
                clearScreen();
                // Countries With the Virus
                printMap(2);
                System.out.println("""
                    How many countries have the virus?
                    Normal games start with none. The virus can spread
                    to adjacent countries and causes a percent of an
                    infected country's population to die.""");
                availableCountries =
                    new ArrayList<Country>(Arrays.asList(countries));
                int numVirus = (int) getNum(0, 72);
                for(i = 0; i < numVirus; i++){
                    clearScreen();
                    printMap(2);
                    System.out.print("Country " + (i + 1) + ": ");
                    Country country = getCountry(availableCountries);
                    country.virus = true;
                    availableCountries.remove(country);
                    gameCode += country.abbrv;
                }
                gameCode += "|";
                clearScreen();
                // Countries With Fallout
                printMap(2);
                System.out.println("""
                    How many countries have fallout?
                    Normal games start with none. Fallout is a
                    possibility when a country is hit by a nuclear
                    weapon.""");
                availableCountries =
                    new ArrayList<Country>(Arrays.asList(countries));
                int numFallout = (int) getNum(0, 72);
                for(i = 0; i < numFallout; i++){
                    clearScreen();
                    printMap(2);
                    System.out.print("Country " + (i + 1) + ": ");
                    Country country = getCountry(availableCountries);
                    country.fallout = true;
                    availableCountries.remove(country);
                    gameCode += country.abbrv;
                }
                gameCode += "|DONE";
                clearScreen();
                // Game and Game Code Creation Complete
                System.out.println("""
                    Game creation completed successfully.
                    Would you like the game code for this game?
                    This would let you create this game later just by
                    loading a game code. Fair warning, the game code
                    for this game is""" + " " + RED_TEXT + gameCode.length() +
                    ANSI_RESET + """
                     characters long.
                    [1] Yes I would like the game code
                    [2] No I would not like the game code""");
                if(getNum(1, 2) == 1){
                    // Game Code
                    clearScreen();
                    System.out.println("""
                        Below is the game code for you to copy. Store this
                        text somwhere you can find it later. It is best
                        to store the text in a plain text file, to ensure
                        the text is not altered in any way (for example,
                        MS Word sometimes will alter text to its own
                        formatting). Note that \"CTRL\" + \"C\" may not
                        copy the game code and may cause problems.\n""");
                    // Printing Game Code
                    System.out.println(gameCode);
                    System.out.println(
                        "\nContinue when you have copied the game code.");
                }
                delayedClearScreen();
        }

        // --Neutral Player Added to end of Lists--
        players.add(playerNeutral);

        // --Fill Player Holders--
        for(Player player : getPlayers(true, true)){
            for(int i = 0; i < 13; i++){
                player.holder.add((long) 0);
            }
        }

        // --Display Players' Info--
        // -Player Names-
        int maxLength = 0;
        int maxWidth = 12;
        for(Player player : getPlayers(true, false)){
            if(player.name.split(" ").length > maxLength){
                maxLength = player.name.split(" ").length;
            }
            for(String piece : player.name.split(" ")){
                if(piece.length() > maxWidth){
                    maxWidth = piece.length();
                }
            }
        }
        for(int i = 0; i < maxLength; i++){
            System.out.print(" ".repeat(9));
            for(Player player : getPlayers(true, false)){
                if(i < player.name.split(" ").length){
                    String piece = player.name.split(" ")[i];
                    System.out.print(" ".repeat(2 + (int)
                        Math.ceil((maxWidth - piece.length()) / 2.0)) +
                        player.textColor + piece + ANSI_RESET +
                        " ".repeat((int)
                        Math.floor((maxWidth - piece.length()) / 2.0)));
                }else{
                    System.out.print(" ".repeat(2 + maxWidth));
                }
            }
            System.out.println();
        }
        String[] titles1= {/*"Bot/Human", Removed until v2.0.0 */
            "Money", "Morale", "Soldiers", "Countries"};
        // -Other-
        for(int i = 0; i < titles1.length; i++){
            System.out.print(titles1[i] +
                " ".repeat(9 - titles1[i].length()));
            String amount;
            for(Player player : getPlayers(true, false)){
                amount = "N/A";
                if(player != playerNeutral || i > 2){
                    switch(i){
                        /*case 0:
                            if(player.bot){
                                amount = "Bot";
                            }else{
                                amount = "Human";
                            }
                            break; Removed until v2.0.0 */
                        case 0: // 1
                            amount = formatNum(player.money);
                            break;
                        case 1: // 2
                            amount = formatDouble(player.morale, 1);
                            break;
                        case 2: // 3
                            amount = formatNum(player.getSoldiers());
                            break;
                        case 3: // 4
                            amount = formatNum(player.getCountries().length);
                    }
                }
                if(amount.length() > maxWidth){
                    amount = formatNum(Long.parseLong(amount.replace(",", "")
                        .replace(".", "").replace(" ", ""))
                         / 1_000_000) + "M";
                    if(amount.length() > maxWidth){
                        amount = "A LOT";
                    }
                }
                System.out.print(" ".repeat(2 + (int) Math.ceil((maxWidth -
                    amount.length()) / 2.0)) + amount + " ".repeat((int)
                    Math.floor((maxWidth - amount.length()) / 2.0)));
            }
            System.out.println();
        }
        System.out.println("\nDeath Total: " + formatNum(deathTotal));
        delayedClearScreen();

        // --All Setup Finished, Print Map--
        printMap(1);
        System.out.println("""
            You are now ready to begin the game.
            Please ensure you have read the rules if you do
            not know how to play already. The rules are on the
            game's website here: ERROR NOT A WEBSITE LINK.""");
        delayedClearScreen();

        // MAIN GAME LOOP
        while(true){

            // --Turn Number--
            System.out.println("TURN " + turnNum);
            turnNum++;
            delayedClearScreen();

            // --Each Player's Original Stats--
            for(Player player : getPlayers(true, false)){
                /*
                 * Holder holds temporary values for future use.
                 * Pos. - Value
                 * Original Values
                 * 0 - Money
                 * 1 - Number of Soldiers
                 * 2 - Morale
                 * 3 - Number of Countries
                 * 4 - Area Controlled
                 * 5 - Military Power
                 * 6 - Total Power
                 * Regular Gains
                 * 7 - Country Soldier Gains
                 * 8 - Region Soldier Gains
                 * 9 - Continent Soldier Gains
                 * Morale Gains
                 * 10 - Money Gains
                 * 11 - Soldier Gains
                 * Virus and Fallout Losses
                 * 12 - Virus Soldier Losses
                 * 13 - Fallout Soldier Losses
                 */
                player.holder.set(0, player.money);
                player.holder.set(1, player.getSoldiers());
                player.holder.set(2, (long) (player.morale) * 10);
                player.holder.set(3, (long) player.getCountries().length);
                player.holder.set(4, (long) 0);
                for(Country country : player.getCountries()){
                    player.holder.set(4, player.holder.get(4) + country.area);
                }
                player.holder.set(5, player.getPower(false));
                player.holder.set(6, player.getPower(true));
            }

            // --Regular Soldier Gains--
            for(Player player : getPlayers(false, false)){
                // -Country Gains-
                /*
                 * Player gains base gain (usually 200) more soldiers
                 * for each controlled country
                 */
                // Calculating Change
                long countryGains =
                    baseGain * (long) player.getCountries().length;
                // Adding Results
                player.reserveSoldiers += countryGains;
                player.holder.set(7, countryGains);
                // -Region Gains-
                /*
                 * Player gains base gain * 0.5 (usually 150) more
                 * soldiers for each country in a controlled
                 * region
                 */
                // Calculating Change
                long regionGains = 0;
                for(Country[] region : new Country[][]{greenland, canada,
                unitedStates, northLatinAmerica, southLatinAmerica,
                northernEurope, southernEurope, northAfrica, centralAfrica,
                southAfrica, westernRussia, easternRussia, westAsia, eastAsia,
                southAsia, pacific, australia}){
                    if(Arrays.asList(player.getCountries())
                    .containsAll(Arrays.asList(region))){
                        regionGains +=
                            (long) (baseGain * 0.5 * region.length);
                        // Morale Change
                        player.addMorale(0.3 * region.length);
                    }
                }
                // Adding Results
                player.reserveSoldiers += regionGains;
                player.holder.set(8, regionGains);
                // -Continent Gains-
                /*
                 * Player gains base gain * 0.75 (usually 150) more
                 * soldiers for each country in a controlled
                 * continent
                 */
                // Calculating Change
                long continentGains = 0;
                for(Country[] continent : new Country[][]{asia, oceania,
                northAmerica, southAmerica, africa, europe}){
                    if(Arrays.asList(player.getCountries())
                    .containsAll(Arrays.asList(continent))){
                        continentGains +=
                            (long) (baseGain * 0.75 * continent.length);
                        // Morale Change
                        player.addMorale(0.3 * continent.length);
                    }
                }
                // Adding Results
                player.reserveSoldiers += continentGains;
                player.holder.set(9, continentGains);
            }

            // --Morale Effects--
            for(Player player : getPlayers(false, false)){
                // -Calculating Effects-
                /*
                 * The percent the number of soldiers in a player's reserves
                 * and every country they control goes up by.
                 */
                double soldierGainPercent = 1 + player.morale * 0.005;
                /*
                 * Amount of money players gain for each soldier they have,
                 * including both deployed and reserve soldiers.
                 */
                double moneyPerSoldier = 2 + player.morale * 0.08;
                // Original/Unchanged Statistics
                long playerOriginalSoldiers = player.getSoldiers();
                // -Applying Effects-
                // Soldier Effects
                for(Country country : player.getCountries()){
                    country.soldiers = (int)
                        Math.round(country.soldiers * soldierGainPercent);
                }
                player.reserveSoldiers = (long)
                    Math.round(player.reserveSoldiers * soldierGainPercent);
                /*
                 * Fixing Possible Rounding Problems
                 * 
                 * Example:
                 * Player 1 owns all countries. Each country and
                 * reserves have 4 soldiers each. Morale soldier gain
                 * of 10%.
                 * Total before gains: 244
                 * Expected after gains: 268
                 * Actual after gains: 244
                 * Missing: 24
                 * 
                 * Explanation:
                 * Since gains are calculated country-by-country instead of
                 * all at once, there may be a few too few or too many
                 * soldiers.
                 * 
                 * Solution:
                 * Add/remove soldiers from countries and reserves.
                 *
                long errorAmount = player.getSoldiers() -
                    Math.round(playerOriginalSoldiers * soldierGainPercent);
                int i = 0;
                while(errorAmount != 0){
                    int amount = 1;
                    if(errorAmount < 0){
                        amount = -1;
                    };
                    if(i == 0 && player.reserveSoldiers > amount){
                        player.reserveSoldiers -= amount;
                        errorAmount -= amount;
                    }else if(i != 0 &&
                    player.getCountries()[i - 1].soldiers > amount){
                        player.getCountries()[i - 1].soldiers -= amount;
                        errorAmount -= amount;
                    }
                    if(i == player.getCountries().length){
                        i = 0;
                    }else{
                        i++;
                    }
                }*/
                // Money Effects
                player.money +=
                    (long) (player.getSoldiers() * moneyPerSoldier);
                // Adding Results
                player.holder.set(10, player.money - player.holder.get(0));
                player.holder.set(11, player.getSoldiers() -
                    playerOriginalSoldiers);
            }

            // --Virus and Fallout Effects--
            // -Adding Slots to Players-
            for(Player player : getPlayers(true, false)){
                player.holder.set(12, (long) 0);
                player.holder.set(13, (long) 0);
            }
            // -Checking Whether Virus/Fallout is Present-
            boolean virusOrFalloutExists = false;
            for(Country country : countries){
                if(country.virus || country.fallout){
                    virusOrFalloutExists = true;
                    break;
                }
            }
            // -Virus Spawning-
            int chance = 12;
            if(virusOrFalloutExists){
                // Chance of Virus Spawning Decreases
                chance = 20;
            }
            if(random.nextInt(0, chance) == 0){
                // -Virus Spawns-
                Country country = countries[random.nextInt(72)];
                while(country.soldiers == 0){
                    country = countries[random.nextInt(72)];
                }
                country.virus = true;
                virusOrFalloutExists = true;
                System.out.println("The " + GREEN_TEXT + "virus" +
                    ANSI_RESET + " spawned in " + country.getColoredName());
                delayedClearScreen();
            }
            if(virusOrFalloutExists){
                // -Adding Elements to Holder-
                for(Country country : countries){
                    if(country.virus){
                        // -Country has the Virus-
                        // Soldier Loss
                        long soldierLoss =
                            Math.round(country.soldiers * 0.15);
                        country.soldiers -= soldierLoss;
                        deathTotal += soldierLoss;
                        country.owner.holder.set(
                            11, country.owner.holder.get(11) - soldierLoss);
                    }
                    if(country.fallout){
                        // -Country has Fallout-
                        // Soldier Loss
                        long soldierLoss = Math.round(country.soldiers * 0.2);
                        country.soldiers -= soldierLoss;
                        deathTotal += soldierLoss;
                        country.owner.holder.set(
                            12, country.owner.holder.get(12) - soldierLoss);
                    }
                }
            }
            // -Morale Changes-
            for(Player player : getPlayers(false, false)){
                // Virus
                player.addMorale(20 * (player.holder.get(12) /
                    (player.holder.get(1) + player.holder.get(7) +
                    player.holder.get(8) + player.holder.get(9) +
                    player.holder.get(11))));
                // Fallout
                player.addMorale(20 * (player.holder.get(12) /
                    (player.holder.get(1) + player.holder.get(7) +
                    player.holder.get(8) + player.holder.get(9) +
                    player.holder.get(11))));
            }

            // --Total Gains--
            System.out.println("TOTAL GAINS\n");
            // -Player Names-
            maxLength = 0;
            maxWidth = 12;
            // Calculating width of columns
            for(Player player : getPlayers(true, false)){
                if(player.name.split(" ").length > maxLength){
                    maxLength = player.name.split(" ").length;
                }
                for(String piece : player.name.split(" ")){
                    if(piece.length() > maxWidth){
                        maxWidth = piece.length();
                    }
                }
            }
            for(int i = 0; i < maxLength; i++){
                System.out.print(" ".repeat(24));
                for(Player player : getPlayers(true, false)){
                    if(i < player.name.split(" ").length){
                        String piece = player.name.split(" ")[i];
                        System.out.print(" ".repeat(2 + (int)
                            Math.ceil((maxWidth - piece.length()) / 2.0)) +
                            player.textColor + piece + ANSI_RESET +
                            " ".repeat((int)
                            Math.floor((maxWidth - piece.length()) / 2.0)));
                    }else{
                        System.out.print(" ".repeat(2 + maxWidth));
                    }
                }
                System.out.println();
            }
            // Printing data
            String[] titles2 = {"ORIGINAL VALUES", "Money", "Soldiers",
                "REGULAR SOLDIER GAINS", "From Owning Countries",
                "From Owning Regions", "From Owning Continents",
                "MORALE GAINS", "Money", "Soldiers",
                "VIRUS AND FALLOUT LOSSES", "Virus", "Fallout",
                "TOTAL GAINS", "Money", "Soldiers",
                "TOTAL", "Money", "Soldiers"};
            for(int i = 0; i < titles2.length; i++){
                if(Character.isUpperCase
                (titles2[i].charAt(titles2[i].length() - 1))){
                    System.out.println(titles2[i]);
                }else{
                    System.out.print(titles2[i] +
                        " ".repeat(24 - titles2[i].length()));
                    for(Player player : getPlayers(true, false)){
                        String amount;
                        if(i < 13){
                            int[] nums =
                                {0, 0, 1, 0, 7, 8, 9, 0, 10, 11, 0, 12, 13};
                            amount = formatNum(player.holder.get(nums[i]));
                        }else if(i == 13){
                            amount = formatNum(player.holder.get(10));
                        }else if(i == 14){
                            amount = formatNum(player.getSoldiers() -
                                player.holder.get(1));
                        }else if(i == 16){
                            amount = formatNum(player.money);
                        }else{
                            amount = formatNum(player.getSoldiers());
                        }
                        if(amount.length() <= maxWidth){
                            if(amount.startsWith("-")){
                                amount = RED_TEXT + " ".repeat(2 + maxWidth -
                                    amount.length()) + amount + ANSI_RESET;
                            }else{
                                amount = GREEN_TEXT + " ".repeat(2 +
                                    maxWidth - amount.length()) + amount +
                                    ANSI_RESET;
                            }
                        }else{
                            amount = formatNum(Long.parseLong(
                                amount.replace(",", "").replace(".", "")
                                .replace(" ", "")) / 1_000_000) + "M";
                            if(amount.length() > maxWidth){
                                if(amount.startsWith("-")){
                                    amount = RED_TEXT +
                                        " ".repeat(maxWidth - 4) + "-A LOT" +
                                        ANSI_RESET;
                                }else{
                                    amount = GREEN_TEXT + " ".repeat(
                                        maxWidth - 3) +"A LOT" + ANSI_RESET;
                                }
                            }else{
                                if(amount.startsWith("-")){
                                    amount = RED_TEXT +
                                        " ".repeat(2 + maxWidth -
                                        amount.length()) + amount +
                                        ANSI_RESET;
                                }else{
                                    amount = GREEN_TEXT + " ".repeat(2 +
                                        maxWidth - amount.length()) + amount +
                                        ANSI_RESET;
                                }
                            }
                            
                        }
                        System.out.print(amount);
                    }
                    System.out.println();
                }
            }
            System.out.println("Death Total: " + RED_TEXT +
                formatNum(deathTotal) + ANSI_RESET + "\n");
            delayedClearScreen();
            printMap(1);
            delayedClearScreen();

            // --Soldier Payment--
            System.out.println("SOLDIER PAYMENT\n");
            delayedClearScreen();
            int choice = 1;
            for(Player player : getPlayers(false, false)){
                /*if(player.bot){
                    // Player is a Bot
                    /*
                     * Methodology:
                     * Bot chooses $6, unless it cannot afford it, in which
                     * case it chooses the most expensive option it can.
                     *//*
                    long amount = 0;
                    for(double i = 6; i >= 5; i -= 0.5){
                        if(player.money >= player.getSoldiers() * i){
                            choice = (int) Math.round(i * 2) - 8;
                            amount = Math.round(player.getSoldiers() * i);
                            player.money -= amount;
                            break;
                        }
                    }
                    System.out.println(player.getColoredName() + " spent $" +
                        (choice * 0.5 + 4) +
                        "/soldier.\nThey spent a total of $" +
                        formatNum(amount) + ".");
                }else{ Removed until v2.0.0 */
                    // -Player's Info-
                    System.out.println(player.getColoredName() +
                        "\nSoldiers: " + formatNum(player.getSoldiers()) +
                        "\nMoney: $" + formatNum(player.money));
                    // -Soldier Playment-
                    System.out.println("""

                        How much would you like to spend on soldier
                        payment?
                        [1] $0 per soldier ($0 total)""");
                    for(int i = 2; i < 7; i++){
                        double num = (i * 0.5 + 4);
                        System.out.println("[" + i + "] $" + num +
                            " per soldier ($" + formatNum((long)
                            (player.getSoldiers() * num)) + " total)");
                    }
                    while(true){
                        choice = (int) getNum(1, 6);
                        if(choice == 1){
                            break;
                        }else if((long) ((choice * 0.5 + 4) *
                        player.getSoldiers()) <= player.money){
                            player.money -= (long) (choice * 0.5 + 4) *
                                player.getSoldiers();
                            break;
                        }else{
                            System.out.println(RED_TEXT +
                                "Too high, choose again." + ANSI_RESET +
                                "\nYour money: $" + formatNum(player.money) +
                                "\nCost: $" + formatNum((long)
                                ((choice * 0.5 + 4) *
                                player.getSoldiers())) + "\n");
                        }
                    }
                //} Removed until v2.0.0
                // Morale Change
                double cost;
                switch(choice){
                    case 1:
                        cost = 0;
                    default:
                        cost = choice * 0.5 + 4;
                }
                player.addMorale(2 * (cost - 6) + 2);
                delayedClearScreen();
            }

            // --Money Spending--
            System.out.println("MONEY SPENDING");
            delayedClearScreen();
            for(Player player : randomizeList(getPlayers(false, false))){
                System.out.println(player.getColoredName() +
                    "'s turn to spend money.");
                delayedClearScreen();
                /*if(player.bot){
                    // Player is a Bot
                    /*
                     * Methodology:
                     * Idk
                     *//*
                }else{ Removed until v2.0.0 */
                    while(true){
                        if(player.money == 0){
                            // Broke players can't spend money
                            clearScreen();
                            break;
                        }
                        // Printing options
                        System.out.println("$" + formatNum(player.money) +
                            " " + """
                            remaining.
                            [1] Buy Soldiers - $7 each
                            [2] Buy Bombs - $""" + formatNum(1000) + """
                             each
                            [3] Buy a Nuclear Weapon - $""" +
                            formatNum(1_000_000) + """
                            
                            [4] Propaganda Campaign - $""" + formatNum((long)
                            (player.getSoldiers() * 0.75)));
                        boolean playerHasVirus = false;
                        boolean playerHasFallout = false;
                        int i = 5;
                        for(Country country : player.getCountries()){
                            if(country.virus){
                                playerHasVirus = true;
                            }
                            if(country.fallout){
                                playerHasFallout = true;
                            }
                        }
                        if(playerHasVirus){
                            System.out.println("[" + i++ +
                                "] Eradicate Virus - $2 per Soldier");
                        }
                        if(playerHasFallout){
                            System.out.println("[" + i++ +
                                "] Clean Up Fallout - $" +
                                formatNum(500_000));
                        }
                        System.out.println("[" + i + "] End Money Spending");
                        choice = (int) getNum(1, i);
                        if(choice == 1){
                            // Buy Soldiers
                            System.out.print("Soldiers: ");
                            long numSoldiers = getNum(0, player.money / 7);
                            player.money -= numSoldiers * 7;
                            player.reserveSoldiers += numSoldiers;
                        }else if(choice == 2){
                            // Buy Bombs
                            System.out.print("Bombs: ");
                            int numBombs =
                                (int) getNum(0, player.money / 1000);
                            player.money -= numBombs * 1000;
                            player.bombs += numBombs;
                        }else if(choice == 3){
                            // Buy a Nuclear Weapon
                            if(player.money >= 1_000_000){
                                player.money -= 1_000_000;
                                player.nuclearWeapons++;
                            }else{
                                System.out.println(RED_TEXT +
                                    "Not enough money." + ANSI_RESET);
                                delayedClearScreen();
                            }
                        }else if(choice == 4){
                            // Propaganda Campaign
                            if(player.money >= (long)
                            (player.getSoldiers() * 0.75)){
                                player.money -= (long)
                                    (player.getSoldiers() * 0.75);
                                player.addMorale(random.nextDouble(10, 15));
                            }else{
                                System.out.println(RED_TEXT +
                                    "Not enough money." + ANSI_RESET);
                                delayedClearScreen();
                            }
                        }else if(choice == 5 && playerHasVirus){
                            // Eradicate Virus
                            clearScreen();
                            printMap(2);
                            System.out.print("Country: ");
                            ArrayList<Country> availableCountries =
                                new ArrayList<Country>(
                                Arrays.asList(player.getCountries()));
                            int ii = availableCountries.size();
                            for(i = 0; i < ii; i++){
                                if(! availableCountries.get(i).virus){
                                    availableCountries.remove(i);
                                    ii--;
                                    i--;
                                }
                            }
                            Country country = getCountry(availableCountries);
                            if(player.money >= country.soldiers * 2){
                                player.money -= country.soldiers * 2;
                                country.virus = false;
                                player.addMorale(2);
                            }else{
                                System.out.println(RED_TEXT +
                                    "Not enough money." + ANSI_RESET +
                                    "\nYour money: $" +
                                    formatNum(player.money) +
                                    "\nCost: $" +
                                    formatNum(country.soldiers * 2));
                                delayedClearScreen();
                            }
                        }else if((choice == 5 && playerHasFallout) ||
                        (choice == 6 && playerHasVirus && playerHasFallout)){
                            // Fallout Clean-Up
                            clearScreen();
                            printMap(2);
                            System.out.print("Country: ");
                            ArrayList<Country> availableCountries =
                                new ArrayList<Country>(
                                Arrays.asList(player.getCountries()));
                            int ii = availableCountries.size();
                            for(i = 0; i < ii; i++){
                                if(! availableCountries.get(i).fallout){
                                    availableCountries.remove(i);
                                    ii--;
                                    i--;
                                }
                            }
                            Country country = getCountry(availableCountries);
                            if(player.money >= 500_000){
                                player.money -= 500_000;
                                country.fallout = false;
                                player.addMorale(2);
                            }else{
                                System.out.println(RED_TEXT +
                                    "Not enough money." + ANSI_RESET);
                                delayedClearScreen();
                            }
                        }else{
                            clearScreen();
                            break;
                        }
                        clearScreen();
                    }
                //} Removed until v2.0.0
            }

            // --Soldier Deployment--
            System.out.println("SOLDIER DEPLOYMENT");
            delayedClearScreen();
            for(Player player : randomizeList(getPlayers(false, false))){
                System.out.println(player.getColoredName() +
                    "'s turn to deploy soldiers.");
                delayedClearScreen();
                /*if(player.bot){
                    // Player is a Bot
                    /*
                     * Methodology:
                     * Figure it out
                     *//*
                    System.out.println(player.getColoredName() + " had " +
                        formatNum(player.reserveSoldiers) +
                        " soldiers to deploy.");
                    delayedClearScreen();
                }else{ Removed until v2.0.0 */
                    while(true){
                        if(player.reserveSoldiers == 0){
                            // Deployment over
                            clearScreen();
                            break;
                        }
                        printMap(1);
                        System.out.println(formatNum(player.reserveSoldiers) +
                            " " + """
                            soldiers left to deploy.
                            [1] Deploy soldiers
                            [2] End soldier deployment""");
                        if(getNum(1, 2) == 1){
                            // Deploy soldiers
                            System.out.print("Choose a country: ");
                            Country country = getCountry(
                                new ArrayList<Country>(
                                Arrays.asList(player.getCountries())));
                            System.out.print(
                                "Number of soldiers to deploy: ");
                            long num = getNum(0, player.reserveSoldiers);
                            player.reserveSoldiers -= num;
                            country.soldiers += num;
                            clearScreen();
                        }else{
                            // End soldier deployment
                            clearScreen();
                            break;
                        }
                    }
                //} Removed until v2.0.0
            }
            System.out.println("End of Soldier Deployment");
            delayedClearScreen();

            // --Warfare--
            System.out.println("WARFARE");
            delayedClearScreen();
            // Available Countries for Invasions List
            for(Player player : getPlayers(false, false)){
                player.availableCountries.clear();
                for(Country country : player.getCountries()){
                    if(! player.availableCountries.contains(country)){
                        player.availableCountries.add(country);
                    }
                    for(Country adjacentCountry : country.adjacentCountries){
                        if(! player.availableCountries
                        .contains(adjacentCountry)){
                            player.availableCountries.add(adjacentCountry);
                        }
                        for(Country adjacentCountry2 :
                        adjacentCountry.adjacentCountries){
                            if(! player.availableCountries
                            .contains(adjacentCountry2)){
                                player.availableCountries
                                    .add(adjacentCountry2);
                            }
                        }
                    }
                }
            }
            int passes = 0;
            while(passes < getPlayers(false, false).size()){
                passes = 0;
                for(Player player : randomizeList(getPlayers(false, false))){
                    if(player.getSoldiers() == 0 && player.bombs == 0 &&
                    player.nuclearWeapons == 0){
                        System.out.println(player.getColoredName() +
                            "'s turn is being skipped, as they\n" +
                            "have no armies, bombs, or nuclear weapons.");
                        passes++;
                        delayedClearScreen();
                        continue;
                    }
                    /*if(player.bot){
                        // Player is a Bot
                        /*
                        * Methodology:
                        * Figure it out
                        *//*
                    }else{ Removed until v2.0.0 */
                        printMap(1);
                        System.out.println(player.getColoredName() + """
                            's turn.
                            [1] Invade/Transfer Soldiers.""");
                        int i = 2;
                        if(player.bombs > 0){
                            System.out.println("[" + i++ + "] Deploy Bombs");
                        }
                        if(player.nuclearWeapons > 0){
                            System.out.println("[" + i++ +
                                "] Deploy Nuclear Weapons");
                        }
                        System.out.println("[" + i + "] Pass");
                        choice = (int) getNum(1, i);
                        if(choice == 1){
                            // Invade/Transfer Soldiers
                            // Starting Country
                            System.out.print("Starting country: ");
                            Country startingCountry = getCountry(
                                new ArrayList<Country>(
                                Arrays.asList(player.getCountries())));
                            ArrayList<Country> options =
                                new ArrayList<Country>();
                            options.addAll(player.availableCountries);
                            ArrayList<Country> options2 =
                                new ArrayList<Country>();
                            options2.addAll(options);
                            for(Country option : options2){
                                if(! Arrays.asList
                                (startingCountry.adjacentCountries)
                                .contains(option)){
                                    options.remove(option);
                                }
                            }
                            // Target Country
                            System.out.print("Target country: ");
                            Country targetCountry = getCountry(options);
                            // Number of Soldiers
                            System.out.print("Soldiers: ");
                            long soldiers =
                                getNum(0, startingCountry.soldiers);
                            startingCountry.soldiers -= soldiers;
                            if(Arrays.asList(player.getCountries())
                            .contains(targetCountry)){
                                // Transfer soldiers
                                System.out.println(player.getColoredName() +
                                    " transferred " + formatNum(soldiers) +
                                    " soldiers from " +
                                    startingCountry.getColoredName() +
                                    " to " + targetCountry.getColoredName());
                                targetCountry.soldiers += soldiers;
                            }else{
                                // Invade
                                Player enemy = targetCountry.owner;
                                long startingCountryLosses = (long)
                                    (random.nextInt(51) / 100.0 *
                                    targetCountry.soldiers);
                                if(startingCountryLosses > soldiers){
                                    startingCountryLosses = soldiers;
                                }
                                soldiers -= startingCountryLosses;
                                deathTotal += startingCountryLosses;
                                if(soldiers > targetCountry.soldiers){
                                    // Success
                                    // Message
                                    System.out.println(
                                        player.getColoredName() + GREEN_TEXT +
                                        " successfully invaded " +
                                        ANSI_RESET +
                                        targetCountry.getColoredName() +
                                        " from " +
                                        startingCountry.getColoredName() +
                                        ".");
                                    // Soldier Changes
                                    deathTotal += targetCountry.soldiers * 2;
                                    targetCountry.soldiers =
                                        soldiers - targetCountry.soldiers;
                                    // Morale Changes
                                    enemy.addMorale(-1);
                                    targetCountry.owner = player;
                                    player.addMorale(2);
                                    if(enemy.getCountries().length == 0){
                                        System.out.println(
                                            player.getColoredName() +
                                            " has eliminated " +
                                            enemy.getColoredName() +
                                            ", whose money ($" +
                                            formatNum(enemy.money) +
                                            "), bombs (" +
                                            formatNum(enemy.bombs) +
                                            "),\nand nuclear weapons (" +
                                            formatNum(enemy.nuclearWeapons) +
                                            ") will be transferred.");
                                        player.money += enemy.money;
                                        player.bombs += enemy.bombs;
                                        player.nuclearWeapons +=
                                            enemy.nuclearWeapons;
                                        enemy.money = 0;
                                        enemy.bombs = 0;
                                        enemy.nuclearWeapons = 0;
                                        enemy.reserveSoldiers = 0;
                                        player.addMorale(10);
                                        passes--;
                                    }
                                }else if(soldiers == targetCountry.soldiers){
                                    // Draw
                                    // Message
                                    System.out.println(
                                        player.getColoredName() +
                                        "'s invasion of " +
                                        targetCountry.getColoredName() +
                                        "from " +
                                        startingCountry.getColoredName() +
                                        YELLOW_TEXT + " ended in a draw." +
                                        ANSI_RESET);
                                    // Soldier Changes
                                    deathTotal += soldiers * 2;
                                    targetCountry.soldiers = 0;
                                }else{
                                    // Fail
                                    // Message
                                    System.out.println(
                                        player.getColoredName() +
                                        RED_TEXT + " failed to invade " +
                                        ANSI_RESET +
                                        targetCountry.getColoredName() +
                                        " from " +
                                        startingCountry.getColoredName() +
                                        ".");
                                    // Soldier Changes
                                    deathTotal += soldiers * 2;
                                    targetCountry.soldiers -= soldiers;
                                    // Morale Change
                                    player.addMorale(-1);
                                }
                            }
                            // Virus Disappearance
                            if(startingCountry.virus &&
                            startingCountry.soldiers == 0){
                                System.out.println(
                                    startingCountry.getColoredName() +
                                    " no longer has the " + GREEN_TEXT +
                                    "virus" + ANSI_RESET +
                                    ", as they have no population.");
                            }
                            if(targetCountry.virus &&
                            targetCountry.soldiers == 0){
                                System.out.println(
                                    targetCountry.getColoredName() +
                                    " no longer has the " + GREEN_TEXT +
                                    "virus" + ANSI_RESET +
                                    ", as they have no population.");
                            }
                            if(startingCountry.virus &&
                            ! targetCountry.virus){
                                targetCountry.virus = true;
                                System.out.println(
                                    targetCountry.getColoredName() +
                                    " got the " + GREEN_TEXT + "virus" +
                                    ANSI_RESET + ".");
                            }
                        }else if(choice == 2 && player.bombs > 0){
                            // Deploy Bombs
                            // Starting Country
                            System.out.print("Starting country: ");
                            Country startingCountry = getCountry(
                                new ArrayList<Country>(
                                Arrays.asList(player.getCountries())));
                            // Target Country
                            System.out.print("Target country: ");
                            Country targetCountry = getCountry(
                                new ArrayList<Country>(Arrays.asList(
                                startingCountry.bombingRangeCountries)));
                            // Number of Bombs
                            System.out.print("Bombs: ");
                            int bombs;
                            if(true || player.bombs < 50_000){
                                bombs = (int) getNum(1, player.bombs);
                            }else{
                                bombs = (int) getNum(0, 50_000);
                            }
                            player.bombs -= bombs;
                            // Soldier Changes
                            long bombDeathTotal = 0;
                            for(i = 0; i < bombs; i++){
                                bombDeathTotal += random.nextInt(40, 81);
                            }
                            if(bombDeathTotal > targetCountry.soldiers){
                                bombDeathTotal = targetCountry.soldiers;
                            }
                            targetCountry.soldiers -= bombDeathTotal;
                            deathTotal += bombDeathTotal;
                            // Message
                            System.out.println(player.getColoredName() +
                                " bombed " + targetCountry.getColoredName() +
                                ", killing " +
                                formatNum(bombDeathTotal) + ".");
                            // Virus Disappearance
                            if(targetCountry.virus &&
                            targetCountry.soldiers == 0){
                                System.out.println(
                                    targetCountry.getColoredName() +
                                    " no longer has the " + GREEN_TEXT +
                                    "virus" + ANSI_RESET +
                                    ", as they have no population.");
                            }
                            // Morale Changes
                            player.addMorale(random.nextDouble(-1, 1));
                            targetCountry.owner
                                .addMorale(-0.1 - 0.001 * bombs);
                        }else if(player.nuclearWeapons > 0 &&
                        ((choice == 2 && player.bombs == 0) ||
                        (choice == 3 && player.bombs > 0))){
                            // Deploy a Nuclear Weapon
                            // Starting Country
                            System.out.print("Starting country: ");
                            Country startingCountry = getCountry(
                                new ArrayList<Country>(
                                Arrays.asList(player.getCountries())));
                            // Target Country
                            System.out.print("Target country: ");
                            Country targetCountry = getCountry(
                                new ArrayList<Country>(Arrays.asList(
                                startingCountry.bombingRangeCountries)));
                            // Number of Nuclear Weapons
                            System.out.print("Nuclear Weapons: ");
                            int nuclearWeapons;
                            if(true || player.nuclearWeapons < 50){
                                nuclearWeapons =
                                    (int) getNum(1, player.nuclearWeapons);
                            }else{
                                nuclearWeapons = (int) getNum(0, 50);
                            }
                            // Message, Soldiers Changes, and Morale Changes
                            System.out.println(player.getColoredName() +
                                " used nuclear weapons against " +
                                targetCountry.getColoredName() +
                                ", killing the following:");
                            player.nuclearWeapons -= nuclearWeapons;
                            long nuclearWeaponsDeathTotal = 0;
                            for(i = 0; i < nuclearWeapons; i++){
                                nuclearWeaponsDeathTotal +=
                                    random.nextInt(50_000, 100_001);
                                player.addMorale(random.nextDouble(-2, 1));
                                targetCountry.owner.addMorale(
                                    -1 * random.nextDouble(2));
                            }
                            if(nuclearWeaponsDeathTotal >
                            targetCountry.soldiers){
                                nuclearWeaponsDeathTotal =
                                    targetCountry.soldiers;
                            }
                            targetCountry.soldiers -=
                                nuclearWeaponsDeathTotal;
                            deathTotal += nuclearWeaponsDeathTotal;
                            System.out.println("  -" + targetCountry
                                .getColoredName() + ": " +
                                formatNum(nuclearWeaponsDeathTotal));
                            for(Country country :
                            targetCountry.adjacentCountries){
                                nuclearWeaponsDeathTotal = 0;
                                for(i = 0; i < nuclearWeapons; i++){
                                    nuclearWeaponsDeathTotal +=
                                        random.nextInt(0, 5001);
                                }
                                if(nuclearWeaponsDeathTotal >
                                country.soldiers){
                                    nuclearWeaponsDeathTotal =
                                        country.soldiers;
                                }
                                country.soldiers -= nuclearWeaponsDeathTotal;
                                deathTotal += nuclearWeaponsDeathTotal;
                                System.out.println("  -" + country
                                    .getColoredName() + ": " +
                                    formatNum(nuclearWeaponsDeathTotal));
                            }
                            // Fallout
                            for(i = 0; i < nuclearWeapons; i++){
                                if(random.nextInt(2) == 1 &&
                                targetCountry.fallout == false){
                                    System.out.println(
                                        targetCountry.getColoredName() +
                                        " has " + PURPLE_TEXT + "fallout" +
                                        ANSI_RESET + ".");
                                    targetCountry.fallout = true;
                                }
                            }
                            // Virus Disappearance
                            if(targetCountry.virus &&
                            targetCountry.soldiers == 0){
                                System.out.println(targetCountry
                                    .getColoredName() +
                                    " no longer has the " + GREEN_TEXT +
                                    "virus" + ANSI_RESET +
                                    ", as they have no population.");
                            }
                            for(Country country :
                            targetCountry.adjacentCountries){
                                if(country.virus && country.soldiers == 0){
                                    System.out.println(
                                        country.getColoredName() +
                                        " no longer has the " + GREEN_TEXT +
                                        "virus" + ANSI_RESET +
                                        ", as they have no population.");
                                }
                            }
                        }else{
                            // Pass
                            passes++;
                        }
                        delayedClearScreen();
                    //} Removed until v2.0.0
                    
                }
                if(getPlayers(false, false).size() == 1){
                    // End of Game
                    break;
                }
            }

            // --Morale Changes--
            for(Player player : getPlayers(false, false)){
                if(player.getCountries().length > player.holder.get(3)){
                    player.addMorale(5);
                }else if(player.getCountries().length ==
                player.holder.get(3)){
                    player.addMorale(-2);
                }else{
                    player.addMorale(-7);
                }
            }

            // --End of Turn Statistics--
            System.out.println("STATISTICS");
            delayedClearScreen();
            String[] titles3 = {"Money", "Soldiers", "Morale",
                "Countries", "Area", "Military Power",
                "Total Potential Power"};
            for(Player player : getPlayers(false, false)){
                System.out.println(player.getColoredName());
                for(int i = 0; i < 7; i++){
                    int ii = 1;
                    for(Player player2 : getPlayers(false, false)){
                        if(player != player2){
                            switch(i){
                                case 0:
                                    if(player2.money > player.money){
                                        ii++;
                                    }
                                    break;
                                case 1:
                                    if(player2.getSoldiers() >
                                    player.getSoldiers()){
                                        ii++;
                                    }
                                    break;
                                case 2:
                                    if(player2.getCountries().length >
                                    player.getCountries().length){
                                        ii++;
                                    }
                                    break;
                                case 3:
                                    if(player2.morale >
                                    player.morale){
                                        ii++;
                                    }
                                    break;
                                case 4:
                                    int totalArea = 0;
                                    int totalArea2 = 0;
                                    for(Country country :
                                    player.getCountries()){
                                        totalArea += country.area;
                                    }
                                    for(Country country :
                                    player2.getCountries()){
                                        totalArea2 += country.area;
                                    }
                                    if(totalArea2 >
                                    totalArea){
                                        ii++;
                                    }
                                    break;
                                case 5:
                                    if((player2.getSoldiers() / 1.25 +
                                    player2.bombs * 60 +
                                    player2.nuclearWeapons * 75_000) >
                                    (player.getSoldiers() / 1.25 +
                                    player.bombs * 60 +
                                    player.nuclearWeapons * 75_000)){
                                        ii++;
                                    }
                                    break;
                                case 6:
                                    if((player2.getSoldiers() / 1.25 +
                                    player2.bombs * 60 +
                                    player2.nuclearWeapons * 75_000) +
                                    player2.money / 8.75 >
                                    (player.getSoldiers() / 1.25 +
                                    player.bombs * 60 +
                                    player.nuclearWeapons * 75_000) +
                                    player.money / 8.75){
                                        ii++;
                                    }
                                    break;
                            }
                        }
                    }
                    System.out.print(titles3[i] + ":" +
                        " ".repeat(23 - titles3[i].length()));
                    double percentChange = 0;
                    try{
                        switch(i){
                            case 0:
                                System.out.print(formatNum(player.money) +
                                    " (#" + ii + ") (");
                                percentChange =
                                    ((double) player.money -
                                    player.holder.get(0)) /
                                    player.holder.get(0) * 100;
                                break;
                            case 1:
                                System.out.print(formatNum(
                                    player.getSoldiers()) + " (#" + ii +
                                    ") (");
                                percentChange =
                                    ((double) player.getSoldiers() -
                                    player.holder.get(1)) /
                                    player.holder.get(1) * 100;
                                break;
                            case 2:
                                System.out.print(
                                    formatDouble(player.morale, 1) +
                                    " (#" + ii + ") (");
                                percentChange =
                                    ((double) player.morale -
                                    (player.holder.get(2) / 10.0)) /
                                    (player.holder.get(2) / 10.0) * 100;
                                break;
                            case 3:
                                System.out.print(
                                    formatNum(player.getCountries().length) +
                                    " (#" + ii + ") (");
                                percentChange =
                                    ((double) player.getCountries().length -
                                    player.holder.get(3)) /
                                    player.holder.get(3) * 100;
                                break;
                            case 4:
                                long value = 0;
                                for(Country country : player.getCountries()){
                                    value += country.area;
                                }
                                System.out.print(formatNum(value) + " (" +
                                    formatDouble(value / 3722.0 * 100, 2) +
                                    "% of the world) (#" + ii + ") (");
                                percentChange =
                                    ((double) value - player.holder.get(4)) /
                                    player.holder.get(4) * 100;
                                break;
                            case 5:
                                value = (long) (player.getSoldiers() / 1.25 +
                                    player.bombs * 60 +
                                    player.nuclearWeapons * 75_000);
                                System.out.print(formatNum(value) + " (#" +
                                    ii + ") (");
                                percentChange =
                                    ((double) value - player.holder.get(5)) /
                                    player.holder.get(5) * 100;
                                break;
                            case 6:
                                value = (long) (player.getSoldiers() / 1.25 +
                                    player.bombs * 60 +
                                    player.nuclearWeapons * 75_000 +
                                    player.money / 8.75);
                                System.out.print(formatNum(value) + " (#" +
                                    ii + ") (");
                                percentChange =
                                    ((double) value - player.holder.get(6)) /
                                    player.holder.get(6) * 100;
                                break;
                        }
                    }catch(Exception ArithmeticException){
                        percentChange = Math.pow(1000, 5);
                    }
                    if(Double.isNaN(percentChange)){
                        percentChange = 0;
                    }
                    if(percentChange < 0){
                        System.out.println(RED_TEXT +
                            formatDouble(percentChange, 2) + "%" +
                            ANSI_RESET + ")");
                    }else{
                        System.out.println(GREEN_TEXT + "+" +
                            formatDouble(percentChange, 2)
                            + "%" + ANSI_RESET + ")");
                    }
                }
                delayedClearScreen();
            }

            // --Game End--
            if(getPlayers(false, false).size() == 1){
                printMap(1);
                System.out.println(
                    getPlayers(false, false).get(0).getColoredName() +
                    GREEN_TEXT + " " + 
                    """
                    has won the game.
                    Congratulations on your victory. You have
                    conquered the world, and vanquished all of your
                    enemies. But your victory was not without
                    sacrifice, as""" + " " + RED_TEXT +
                    formatNum(deathTotal) + GREEN_TEXT + " soldiers died." +
                    ANSI_RESET + "\nThanks for playing, goodbye.");
                System.exit(0);
            }
        }
    }

    // Other Methods

    /**
     * Clears the console.
     * <p>
     * Prompts for user input (which it doesn't use),
     * then clears the screen. User input is used to
     * ensure a delay before clearing.
     * <p>
     */
    public static void clearScreen(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

    /**
     * Prompts the user for input and then clears the
     * screen.
     * <p>
     * Prompts the user for input, which it doesn't use,
     * in order to create a delay. Then clears the
     * screen.
     * <p>
     */
    public static void delayedClearScreen(){
        System.out.println("\n[ENTER]");
        scanner.nextLine();
        clearScreen();
    }

    /**
     * Formats large numbers.
     * <p>
     * Formats large numbers to a variety of different
     * formats based on the user's chosen preference.
     * The user's preference, numFormat, is a static
     * vaiable not passed to the function.
     * <p>
     * @param num - num to be formatted
     * @return formatted num, now a String
     */
    public static String formatNum(long num){
        /*
         * Initial Formatting
         * 1234567  -->  1,234,567
         */
        String formattedNum = String.format("%,8d%n", num).strip()
            .replace(",", "s").replace(".", "d");
        return formattedNum
            .replace("s", numSeparator).replace("b", numDecimal);
    }

    /**
     * Formats large non-integer numbers.
     * <p>
     * Formats large numbers to a variety of different
     * formats based on the user's chosen preference.
     * The user's preference, numFormat, is a static
     * vaiable not passed to the function. Also keeps
     * digits after the decimal (which are not formatted)
     * in any way.
     * <p>
     * @param num - double to be formatted
     * @param dec - number of places after decimal to keep
     * @return formatted double, now a String
     */
    public static String formatDouble(double num, int dec){
        String str = "";
        double numPos = Math.abs(num);
        if(num < 0){
            str = "-";
        }
        if(numPos >= Math.pow(1000, 5)){
            str += "\u221E";
        }else{
            // Formatting int portion.
            str += formatNum((long) Math.floor(numPos)) +
                // Adding double portion to end of String.
                String.format("%." + dec + "f", numPos - (int) numPos)
                .replaceFirst("0", "");
        }
        return str;
    }

    /**
     * Gets a user's choice from a list of Countries.
     * <p>
     * Gets a user's choice from a list of possible
     * Country objects.
     * <p>
     * @param choices - user's options
     * @return Country chosen
     */
    public static Country getCountry(ArrayList<Country> choices){
        while(true){
            // Get Choice
            String choice = scanner.nextLine();
            for(Country country : choices){
                if(country.name.equals(choice) ||
                country.abbrv.equals(choice)){
                    // Choice Exists
                    return country;
                }
            }
            // Choice Does Not Exist
            System.out.println(RED_TEXT + """
                Your choice was not in the list of available options.
                Here are your options:""");
            // Print Possible Choices
            for(int i = 0; i < choices.size(); i++){
                Country country = choices.get(i);
                System.out.print(country.name +
                    " ".repeat(23 - country.name.length()));
                if(i % 2 != 0 && i != choices.size() - 1){
                    System.out.println();
                }
            }
            System.out.println(ANSI_RESET);
        }
    }

    /**
     * Gets long input from the user.
     * <p>
     * Gets long input from the user, between given
     * minimum and maximum values.
     * <p>
     * @param min - minimum possible value (inclusive)
     * @param max - maximum possible value (inclusive)
     * @return long chosen
     */
    public static long getNum(long min, long max){
        while(true){
            try{
                // Get Choice
                String choiceString = scanner.nextLine().toLowerCase()
                    .replace(numSeparator, "").replace(numDecimal, ".");
                if(choiceString.equals("all")){
                    return max;
                }
                /*
                 * Removing Suffixes
                 * Ex. 50M --> 50000000
                 */
                String[] suffixes = {"K", "M", "B", "T", "Q"};
                for(int i = 0; i < suffixes.length; i++){
                    choiceString = choiceString.replace(suffixes[i],
                        "0".repeat(3 * (i + 1)));
                }
                long choice = Long.parseLong(choiceString);
                if(min <= choice && choice <= max){
                    // Choice is Acceptable
                    return choice;
                }else{
                    // Choice is not Acceptable
                    System.out.println(RED_TEXT +
                        "Choice must be greater than " + formatNum(min - 1) +
                        " and less than " + formatNum(max + 1) + "." +
                        ANSI_RESET);
                }
            }catch(Exception InputMismatchException){
                // Choice is Not an Integer
                System.out.println(RED_TEXT +
                    "Choice must be an integer." + ANSI_RESET);
            }
        }
    }

    /**
     * Returns a list of players.
     * <p>
     * Returns a list of players, with the option to
     * include playerNeutral and players who have been
     * eliminated.
     * <p>
     * @param includeNeutral - inlcude playerNeutral
     * @param includeEliminatedPlayers - include players
     * who have been eliminated
     * @return list of players
     */
    public static ArrayList<Player> getPlayers(boolean includeNeutral,
    boolean includeEliminatedPlayers){
        ArrayList<Player> playerList = players;
        if((! includeNeutral) &&
        playerList.get(playerList.size() - 1).name.equals("Neutral")){
            playerList.remove(playerList.size() - 1);
        }
        if(! includeEliminatedPlayers){
            for(int i = 0; i < playerList.size(); i++){
                if(playerList.get(i).availableCountries.size() == 0){
                    playerList.remove(i);
                    i -= 1;
                }
            }
        }
        return playerList;
    }

    /**
     * Prints a map, focused on a specific country.
     * <p>
     * Prints the Kingdom of War - Global Conquest Map,
     * focused on a specific country. Highlights
     * countries adjacent to said country and countries
     * in its bombing range.
     * <p>
     * @param country - country to focus on
     */
    public static void printCountryMap(Country country){
        // Getting Foreground Text and Removing Information From Map
        String newForeground = FOREGROUND_TEXT;
        for(Country eachCountry : countries){
            newForeground =
                newForeground.replace("|" + eachCountry.abbrv, "    ")
                .replace("*" + eachCountry.abbrv, "    ");
        }
        // Printing Map
        for(int y = 0; y < BACKGROUND_CODES.length; y++){
            String[] codes = BACKGROUND_CODES[y].split(" ");
            for(int x = 0; x < codes.length; x++){
                String pixelBack = codes[x].substring(0, 3);
                String pixelFore = codes[x].substring(3, 6);
                String colorBack = "20";
                String colorFore = "20";
                for(Country eachCountry : countries){
                    if(pixelBack.equals(eachCountry.abbrv)){
                        if(country == eachCountry){
                            colorBack =
                                GREEN_COLOR_LIST[eachCountry.colorLevel];
                        }else if(Arrays.asList(country.adjacentCountries)
                        .contains(eachCountry)){
                            colorBack =
                                RED_COLOR_LIST[eachCountry.colorLevel];
                        }else if(Arrays.asList(country.bombingRangeCountries)
                        .contains(eachCountry)){
                            colorBack =
                                BLACK_COLOR_LIST[eachCountry.colorLevel];
                        }else{
                            colorBack =
                                GRAY_COLOR_LIST[eachCountry.colorLevel];
                        }
                    }
                    if(pixelFore.equals(eachCountry.abbrv)){
                        if(country == eachCountry){
                            colorFore =
                                GREEN_COLOR_LIST[eachCountry.colorLevel];
                        }else if(Arrays.asList(country.adjacentCountries)
                        .contains(eachCountry)){
                            colorFore =
                                RED_COLOR_LIST[eachCountry.colorLevel];
                        }else if(Arrays.asList(country.bombingRangeCountries)
                        .contains(eachCountry)){
                            colorFore =
                                BLACK_COLOR_LIST[eachCountry.colorLevel];
                        }else{
                            colorFore =
                                GRAY_COLOR_LIST[eachCountry.colorLevel];
                        }
                    }
                }
                System.out.print("\u001b[48;5;" + colorBack +
                    "m\u001b[38;5;" + colorFore + "m" +
                    newForeground.charAt(149 * (y) + x));
            }
            System.out.println(ANSI_RESET);
        }
    }


    /**
     * Prints the map.
     * <p>
     * Prints the Kingdom of War - Global Conquest Map.
     * Prints normal, virus, or fallout map.
     * <p>
     * @param type - type of map, with 1 being normal,
     * 2 being a virus map, and 3 being a fallout map
     */
    public static void printMap(int type){
        String newForeground = FOREGROUND_TEXT;
        switch(type){
            case 1:
                // Normal Map
                // Adding Country Info to Map
                switch(mapInfoChoice1){
                    case 1:
                        for(Country country : countries){
                            newForeground =
                                newForeground.replace("|" + country.abbrv,
                                Long.toString(country.soldiers));
                        }
                    case 2:
                        for(Country country : countries){
                            newForeground =
                                newForeground.replace("|" + country.abbrv,
                                Long.toString(country.nuclearWeapons));
                        }
                    case 3:
                        for(Country country : countries){
                            newForeground =
                                newForeground.replace("|" + country.abbrv,
                                Long.toString(country.bombs));
                        }
                }
                // Printing Map
                for(int y = 0; y < BACKGROUND_CODES.length; y++){
                    String[] codes = BACKGROUND_CODES[y].split(" ");
                    for(int x = 0; x < codes.length; x++){
                        String pixelBack = codes[x].substring(0, 3);
                        String pixelFore = codes[x].substring(3, 6);
                        String colorBack = "20";
                        String colorFore = "20";
                        for(Country country : countries){
                            if(pixelBack.equals(country.abbrv)){
                                colorBack =
                                    country.owner.color[country.colorLevel];
                            }
                            if(pixelFore.equals(country.abbrv)){
                                colorFore =
                                    country.owner.color[country.colorLevel];
                            }
                        }
                        System.out.print("\u001b[48;5;" + colorBack +
                            "m\u001b[38;5;" + colorFore + "m" +
                            newForeground.charAt(149 * (y) + x));
                    }
                    System.out.println(ANSI_RESET);
                }
            case 2:
                // Virus Map
                // Adding Country Info to Map
                double max = 0;
                for(Country country : countries){
                    newForeground = newForeground.replace("|" + country.abbrv,
                        Double.toString(Math.round((double)
                        country.soldiersInfected / country.soldiers * 1000)
                        / 10.0));
                    double percentInfected =
                        (double) country.soldiersInfected / country.soldiers;
                    if(percentInfected > max){
                        max = percentInfected;
                    }
                }
                double range = max / 25;
                // Printing Map
                for(int y = 0; y < BACKGROUND_CODES.length; y++){
                    String[] codes = BACKGROUND_CODES[y].split(" ");
                    for(int x = 0; x < codes.length; x++){
                        String pixelBack = codes[x].substring(0, 3);
                        String pixelFore = codes[x].substring(3, 6);
                        String colorBack = "20";
                        String colorFore = "20";
                        for(Country country : countries){
                            if(pixelBack.equals(country.abbrv)){
                                for(int i = 0; i < 25; i++){
                                    if((double) country.soldiersInfected /
                                    country.soldiers <= (i + 1) * range){
                                        pixelBack = Integer.toString(232 + i);
                                    }
                                }
                            }
                            if(pixelFore.equals(country.abbrv)){
                                for(int i = 0; i < 25; i++){
                                    if((double) country.soldiersInfected /
                                    country.soldiers <= (i + 1) * range){
                                        pixelFore = Integer.toString(232 + i);
                                    }
                                }
                            }
                        }
                        System.out.print("\u001b[48;5;" + colorBack +
                            "m\u001b[38;5;" + colorFore + "m" +
                            newForeground.charAt(149 * (y) + x));
                    }
                    System.out.println(ANSI_RESET);
                }
            case 3:
                // Fallout Map
                // Adding Country Info to Map
                for(Country country : countries){
                    newForeground = newForeground.replace("|" + country.abbrv,
                        Integer.toString(country.timesNuked));
                }
        }
    }

    /**
     * Randomizes the order of elements in a list.
     * <p>
     * Randomizes the order of elements in a list,
     * returns result as a array. List and array both of
     * Player.
     * <p>
     * @param list - list to shuffle
     * @return shuffled list, as an array
     */
    public static Player[] randomizeList(ArrayList<Player> list){
        // Creates Empty Array
        Player[] shuffledArray = new Player[list.size()];
        for(Player player : list){
            while(true){
                // Choses Possible Position
                int i = random.nextInt(list.size());
                if(shuffledArray[i] == null){
                    // Position Empty
                    shuffledArray[i] = player;
                    break;
                }
            }
        }
        // Return Shuffled Array
        return shuffledArray;
    }

    /**
     * Reads a file's contents.
     * <p>
     * Reads and returns a file's contents.
     * <p>
     * @param path - path of the target file
     * @return the file's contents
     */
    public static String readFile(String path){
        String fileContents = "";
        try{
            // Reading File
            Scanner fileScanner =
                new Scanner(new File(FILE_DIRECTORY + path));
            while(fileScanner.hasNextLine()){
                fileContents += fileScanner.nextLine();
                if(fileScanner.hasNextLine()){
                    fileContents += "\n";
                }
            }
            fileScanner.close();
        }catch(Exception FileNotFoundException){
            // File Not Found
            FileNotFoundException.printStackTrace();
            System.out.println(RED_TEXT + "The file " + ANSI_RESET +
                path + RED_TEXT + """
                 cannot be found.
                Please report this error to the game's creator.""" +
                ANSI_RESET);
            System.exit(0);
        }
        // Return File Contents (Read was Successful)
        return fileContents;
    }
}

class Country{
    // VARIABLES

    // Basics
    String name;
    /*
     * Abbreviations are used to store the country in
     * various things, such as:
     * -game codes
     * -map background codes
     * -map foreground placeholders
     */
    String abbrv;
    Player owner;

    // Military
    long soldiers = 0;
    /*
     * Every soldier can make 2 moves per turn,
     * this tracks how many moves a soldier has left
     */
    long soldiers0Move = 0;
    long soldiers1Move = 0;
    long soldiers2Move = 0;
    int bombs = 0;
    int nuclearWeapons = 0;
    Country[] adjacentCountries;
    Country[] bombingRangeCountries;

    // Virus and Fallout
    long soldiersInfected = 0;
    int timesNuked = 0;

    // Other
    // Used in map printing
    int colorLevel;
    // Area of country on map in pixels
    int area;

    // PASSED VARIABLES
    Country(String name, String abbrv, int colorLevel, int area){
        this.name = name;
        this.abbrv = abbrv;
        this.colorLevel = colorLevel - 1;
        this.area = area;
    }

    // METHODS

    /**
     * Returns a the country's name, in its owner's
     * text color.
     * <p>
     * Sets text color to country's owner's text color,
     * add country's name, then resets text color.
     * <p>
     * @return country's name, with owner's text color
     */
    public String getColoredName(){
        return this.owner.textColor + this.name + "\u001b[0m";
    }
}

class Player{
    // VARIABLES

    // Basics
    //boolean bot; Removed until v2.0.0
    String name;
    String textColor;
    String[] color;

    // Resources
    long money = 1000;
    long reserveSoldiers = 0;
    double morale = 50;

    // Holder
    // Holds temporary data
    ArrayList<Long> holder = new ArrayList<Long>();

    // Available Countries
    // Used in invasions
    ArrayList<Country> availableCountries = new ArrayList<Country>();

    // PASSED VARIABLES
    Player(/*boolean bot, */String name, char color){
        //this.bot = bot;
        this.name = name;
        switch(color){
            case 'r':
                this.color = KingdomOfWarGlobalConquest.RED_COLOR_LIST;
                break;
            case 'y':
                this.color = KingdomOfWarGlobalConquest.YELLOW_COLOR_LIST;
                break;
            case 'g':
                this.color = KingdomOfWarGlobalConquest.GREEN_COLOR_LIST;
                break;
            case 'b':
                this.color = KingdomOfWarGlobalConquest.BLUE_COLOR_LIST;
                break;
            case 'p':
                this.color = KingdomOfWarGlobalConquest.PURPLE_COLOR_LIST;
                break;
            case 'k':
                this.color = KingdomOfWarGlobalConquest.PINK_COLOR_LIST;
                break;
            case 'n':
                this.color = KingdomOfWarGlobalConquest.GRAY_COLOR_LIST;
                /*
                 * Text color only set for neutral player, others set during
                 * player creation
                 */
                this.textColor = "\u001b[38;5;248;1m";
                break;
        }
    }

    // METHODS

    /**
     * Adds to a player's morale.
     * <p>
     * Adds an amount to a player's morale, and ensures
     * that the player's morale does not go above 100 or
     * below 0.
     * <p>
     * @param num - amount to add (can be negative)
     */
    public void addMorale(double num){
        morale += num;
        if(morale > 100){
            morale = 100;
        }else if(morale < 0){
            morale = 0;
        }
        morale = Math.round(morale * 10) / 10.0;
    }

    /**
     * Counts player's bombs.
     * @return total bombs
     */
    public int getBombs(){
        int total = 0;
        // Counting Bombs From Each Country
        for(Country country : this.getCountries()){
            total += country.bombs;
        }
        return total;
    }

    /**
     * Get's a player's name in their color.
     * <p>
     * Returns a player's name, in their color of text.
     * Also reset's color to normal afterwards.
     * <p>
     * @return color + player's name + color reset
     */
    public String getColoredName(){
        return this.textColor + this.name + "\u001b[0m";
    }

    /**
     * Gets a player's countries.
     * <p>
     * Returns all countries that have the player as
     * their owner.
     * <p>
     * @return list of player's countries
     */
    public Country[] getCountries(){
        // Count Total Countries
        int totCountries = 0;
        for(Country country : KingdomOfWarGlobalConquest.countries){
            if(country.owner == this){
                totCountries++;
            }
        }
        // Create and Return List of Countries
        int i = 0;
        Country[] resultCountries = new Country[totCountries];
        for(Country country : KingdomOfWarGlobalConquest.countries){
            if(country.owner == this){
                resultCountries[i++] = country;
            }
        }
        return resultCountries;
    }

    /**
     * Counts player's nuclear weapons.
     * @return total nuclear weapons
     */
    public int getNuclearWeapons(){
        int total = 0;
        // Counting Nuclear Weapons From Each Country
        for(Country country : this.getCountries()){
            total += country.nuclearWeapons;
        }
        return total;
    }

    public long getPower(boolean totalPower){
        long total = (long) (this.getSoldiers() / 1.25 +
            this.getBombs() * 60 + this.getNuclearWeapons() * 75_000);
        if(totalPower){
            total += (long) (this.money / (1.25 * 7));
        }
        return total;
    }

    /**
     * Counts player's soldiers.
     * <p>
     * Counts player's soldiers, includes player's reserves.
     * <p>
     * @return total soldiers
     */
    public long getSoldiers(){
        long total = 0;
        // Soldiers Deployed to Player's Countries
        for(Country country : this.getCountries()){
            total += country.soldiers;
        }
        // Soldiers in Player's Reserves
        total += reserveSoldiers;
        return total;
    }
}
