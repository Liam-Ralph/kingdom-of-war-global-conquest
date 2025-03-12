/* 
 * Kingdom of War - Global Conquest
 */

// IMPORTS
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class OldKingdomOfWarGlobalConquest{
    // VARIABLES

    // Version
    static String version = "v0.0.3";

    // Directory
    static final String FILE_DIRECTORY =
        "Text Files (KoWGC v0.0.1)/";
    
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
    static final String[] YELLOW_COLOR_LIST = {"208", "214", "220", "227"};
    static final String[] GREEN_COLOR_LIST = {"22", "28", "34", "40"};
    static final String[] BLUE_COLOR_LIST = {"33", "39", "45", "87"};
    static final String[] PURPLE_COLOR_LIST = {"54", "55", "56", "57"};
    static final String[] PINK_COLOR_LIST = {"197", "200", "207", "213"};
    static final String[] GREY_COLOR_LIST = {"239", "242", "245", "248"};

    // Ansi Reset
    static final String ANSI_RESET = "\u001b[0m";

    // Map Data
    static final String FOREGROUND_TEXT =
        readFile("Foreground.txt").replace("_", "▄");
    static final String[] BACKGROUND_CODES =
        readFile("Background.txt").replace("\n", "").split(" ");

    // Number Formatting Preference
    static int numFormat;
    /*
     * Countries
     * Creating countries with name, long abbreviation, short abbreviation,
     * lightness level (used in map printing), and area
     */
    static OldCountry ural = new OldCountry("Ural", "Ura", 'a', 2, 163);
    static OldCountry northernSiberia =
        new OldCountry("Northern Siberia", "Nsi", 'b', 0, 107);
    static OldCountry southernSiberia =
        new OldCountry("Southern Siberia", "Ssi", 'c', 1, 98);
    static OldCountry sakha = new OldCountry("Sakha", "Sak", 'd', 3, 164);
    static OldCountry easternRussia =
        new OldCountry("Eastern Russia", "Eru", 'e', 1, 118);
    static OldCountry northernChina =
        new OldCountry("Northern China", "Ncn", 'f', 2, 128);
    static OldCountry southernChina =
        new OldCountry("Southern China", "Scn", 'g', 0, 81);
    static OldCountry japan = new OldCountry("Japan", "Jpn", 'h', 2, 23);
    static OldCountry korea = new OldCountry("Korea", "Kor", 'i', 1, 13);
    static OldCountry mongolia = new OldCountry("Mongolia", "Mng", 'j', 0, 57);
    static OldCountry kazakhstan = new OldCountry("Kazakhstan", "Kaz", 'k', 3, 49);
    static OldCountry indonesia = new OldCountry("Indonesia", "Idn", 'l', 2, 42);
    static OldCountry india = new OldCountry("India", "Ind", 'm', 3, 53);
    static OldCountry arabia = new OldCountry("Arabia", "Arb", 'n', 1, 61);
    static OldCountry centralAsia =
        new OldCountry("Central Asia", "Cas", 'o', 0, 54);
    static OldCountry southeastAsia =
        new OldCountry("Southeast Asia", "Sea", 'p', 1, 32);
    static OldCountry westernAustralia =
        new OldCountry("Western Australia", "Wau", 'q', 1, 58);
    static OldCountry tasmania = new OldCountry("Tasmania", "Tas", 'r', 0, 45);
    static OldCountry queensland = new OldCountry("Queensland", "Qln", 's', 3, 57);
    static OldCountry newZealand =
        new OldCountry("New Zealand", "Nzl", 't', 1, 14);
    static OldCountry centralAmerica =
        new OldCountry("Central America", "Cam", 'u', 0, 9);
    static OldCountry caribbeanAmerica =
        new OldCountry("Caribbean America", "Car", 'v', 2, 18);
    static OldCountry mexico = new OldCountry("Mexico", "Mex", 'w', 3, 69);
    static OldCountry middleAmerica =
        new OldCountry("Middle America", "Mam", 'x', 0, 79);
    static OldCountry pacificAmerica =
        new OldCountry("Pacific America", "Pam", 'y', 1, 44);
    static OldCountry atlanticAmerica =
        new OldCountry("Atlantic America", "Aam", 'z', 1, 52);
    static OldCountry easternCanada =
        new OldCountry("Eastern Canada", "Eca", 'A', 3, 121);
    static OldCountry westernCanada =
        new OldCountry("Western Canada", "Wca", 'B', 2, 79);
    static OldCountry yukonCanada =
        new OldCountry("Yukon Canada", "Yca", 'C', 3, 110);
    static OldCountry nunavut = new OldCountry("Nunavut", "Nvt", 'D', 1, 171);
    static OldCountry easternGreenland =
        new OldCountry("Eastern Greenland", "Egl", 'E', 0, 111);
    static OldCountry westernGreenland =
        new OldCountry("Western Greenland", "Wgl", 'F', 2, 139);
    static OldCountry alaska = new OldCountry("Alaska", "Ask", 'G', 0, 85);
    static OldCountry brazil = new OldCountry("Brazil", "Brz", 'H', 3, 121);
    static OldCountry argentina = new OldCountry("Argentina", "Arg", 'I', 0, 59);
    static OldCountry chile = new OldCountry("Chile", "Chl", 'J', 3, 32);
    static OldCountry peru = new OldCountry("Peru", "Per", 'K', 2, 39);
    static OldCountry colombiaVenezuela =
        new OldCountry("Colombia-Venezuela", "Cov", 'L', 1, 55);
    static OldCountry southAfrica =
        new OldCountry("South Africa", "Saf", 'M', 3, 21);
    static OldCountry northAfrica =
        new OldCountry("North Africa", "Naf", 'N', 1, 76);
    static OldCountry centralAfrica =
        new OldCountry("Central Africa", "Caf", 'O', 3, 64);
    static OldCountry middleAfrica =
        new OldCountry("Middle Africa", "Maf", 'P', 2, 71);
    static OldCountry atlanticAfrica =
        new OldCountry("Atlantic Africa", "Aaf", 'Q', 1, 27);
    static OldCountry westernAfrica =
        new OldCountry("Western Africa", "Waf", 'R', 0, 60);
    static OldCountry easternAfrica =
        new OldCountry("Eastern Africa", "Eaf", 'S', 0, 48);
    static OldCountry egypt = new OldCountry("Egypt", "Egy", 'T', 3, 23);
    static OldCountry mozambiqueMadagascar =
        new OldCountry("Mozambique-Madagascar", "Mzm", 'U', 2, 28);
    static OldCountry nambiaBotswana =
        new OldCountry("Nambia-Botswana", "Nab", 'V', 1, 31);
    static OldCountry scandinavia =
        new OldCountry("Scandinavia", "Scd", 'W', 3, 92);
    static OldCountry britain = new OldCountry("Britain", "Brt", 'X', 1, 17);
    static OldCountry france = new OldCountry("France", "Fra", 'Y', 0, 25);
    static OldCountry germany = new OldCountry("Germany", "Ger", 'Z', 1, 23);
    static OldCountry spain = new OldCountry("Spain", "Spn", '2', 3, 15);
    static OldCountry italy = new OldCountry("Italy", "Ita", '3', 2, 19);
    static OldCountry turkey = new OldCountry("Turkey", "Tur", '4', 2, 25);
    static OldCountry poland = new OldCountry("Poland", "Pol", '5', 0, 31);
    static OldCountry belgium = new OldCountry("Belgium", "Bel", '6', 2, 9);
    static OldCountry austriaHungary =
        new OldCountry("Austria-Hungary", "Auh", '7', 3, 11);
    static OldCountry moscow = new OldCountry("Moscow", "Mcw", '8', 1, 181);
    static OldCountry greece = new OldCountry("Greece", "Grc", '9', 0, 15);

    // Continent Lists and Countries List
    static OldCountry[] asia = {ural, northernSiberia, southernSiberia, sakha,
        easternRussia, northernChina, southernChina, japan, korea, mongolia,
        kazakhstan, indonesia, india, arabia, centralAsia, southeastAsia};
    static OldCountry[] oceania = {westernAustralia, tasmania, queensland,
        newZealand};
    static OldCountry[] northAmerica = {centralAmerica, caribbeanAmerica, mexico,
        middleAmerica, pacificAmerica, atlanticAmerica, easternCanada,
        westernCanada, yukonCanada, nunavut, easternGreenland,
        westernGreenland, alaska};
    static OldCountry[] southAmerica = {brazil, argentina, chile, peru,
        colombiaVenezuela};
    static OldCountry[] africa = {southAfrica, northAfrica, centralAfrica,
        middleAfrica, atlanticAfrica, westernAfrica, easternAfrica, egypt,
        mozambiqueMadagascar, nambiaBotswana};
    static OldCountry[] europe = {scandinavia, britain, france, germany, spain,
        italy, turkey, poland, belgium, austriaHungary, moscow, greece};
    // All countries
    static OldCountry[] countries = new OldCountry[60];

    // METHODS

    // Main Method

    public static void main(String[] args){

        // SETUP

        // --Neutral OldPlayer--
        // Used to represent neutral countries, doesn't actually play
        OldPlayer playerNeutral = new OldPlayer(true, "Neutral", 'n');
        playerNeutral.money = 0;
        playerNeutral.reserveSoldiers = 0;

        // --Coutry Adjacent and Bomb/Nuclear Weapon Range Lists--
        // -OldCountry Adjacent Lists-
        // Each country's list of countries adjacent to it
        ural.adjacentCountries = new OldCountry[]{moscow, kazakhstan, mongolia,
            southernSiberia, northernSiberia};
        northernSiberia.adjacentCountries = new OldCountry[]{ural,
            southernSiberia, sakha};
        southernSiberia.adjacentCountries = new OldCountry[]{ural, mongolia,
            sakha, northernSiberia};
        sakha.adjacentCountries = new OldCountry[]{northernSiberia,
            southernSiberia, northernChina, korea, easternRussia};
        easternRussia.adjacentCountries = new OldCountry[]{sakha, japan, alaska};
        northernChina.adjacentCountries = new OldCountry[]{kazakhstan,
            centralAsia, india, southernChina, korea, sakha, mongolia};
        southernChina.adjacentCountries = new OldCountry[]{northernChina,
            southeastAsia, japan, korea};
        japan.adjacentCountries = new OldCountry[]{korea, southernChina,
            pacificAmerica, easternRussia};
        korea.adjacentCountries = new OldCountry[]{northernChina, southernChina,
            japan, sakha};
        mongolia.adjacentCountries = new OldCountry[]{ural, kazakhstan,
            northernChina, southernSiberia};
        kazakhstan.adjacentCountries = new OldCountry[]{moscow, centralAsia,
            northernChina, mongolia, ural};
        indonesia.adjacentCountries = new OldCountry[]{westernAustralia,
            queensland, southeastAsia};
        india.adjacentCountries = new OldCountry[]{centralAsia, southeastAsia,
            northernChina};
        arabia.adjacentCountries = new OldCountry[]{turkey, egypt,
            easternAfrica, centralAsia};
        centralAsia.adjacentCountries = new OldCountry[]{arabia, india,
            northernChina, kazakhstan};
        southeastAsia.adjacentCountries = new OldCountry[]{india, indonesia,
            southernChina};
        westernAustralia.adjacentCountries = new OldCountry[]{indonesia,
            tasmania, queensland};
        tasmania.adjacentCountries = new OldCountry[]{westernAustralia,
            newZealand, queensland};
        queensland.adjacentCountries = new OldCountry[]{indonesia,
            westernAustralia, tasmania, newZealand};
        newZealand.adjacentCountries = new OldCountry[]{queensland, tasmania,
            peru};
        centralAmerica.adjacentCountries = new OldCountry[]{mexico,
            colombiaVenezuela, caribbeanAmerica};
        caribbeanAmerica.adjacentCountries = new OldCountry[]{atlanticAmerica,
            centralAmerica, colombiaVenezuela};
        mexico.adjacentCountries = new OldCountry[]{pacificAmerica,
            centralAmerica, middleAmerica};
        middleAmerica.adjacentCountries = new OldCountry[]{westernCanada,
            pacificAmerica, mexico, atlanticAmerica};
        pacificAmerica.adjacentCountries = new OldCountry[]{japan, mexico,
            middleAmerica, westernCanada};
        atlanticAmerica.adjacentCountries = new OldCountry[]{middleAmerica,
            caribbeanAmerica, britain, easternCanada};
        easternCanada.adjacentCountries = new OldCountry[]{nunavut,
            westernCanada, atlanticAmerica, westernGreenland};
        westernCanada.adjacentCountries = new OldCountry[]{yukonCanada, alaska,
            pacificAmerica, middleAmerica, easternCanada, nunavut};
        yukonCanada.adjacentCountries = new OldCountry[]{alaska, westernCanada,
            nunavut};
        nunavut.adjacentCountries = new OldCountry[]{yukonCanada, westernCanada,
            easternCanada, westernGreenland};
        easternGreenland.adjacentCountries = new OldCountry[]{westernGreenland,
            britain, scandinavia};
        westernGreenland.adjacentCountries = new OldCountry[]{nunavut,
            easternCanada, easternGreenland};
        alaska.adjacentCountries = new OldCountry[]{easternRussia,
            westernCanada, yukonCanada};
        brazil.adjacentCountries = new OldCountry[]{colombiaVenezuela, peru,
            argentina, atlanticAfrica};
        argentina.adjacentCountries = new OldCountry[]{peru, chile, brazil};
        chile.adjacentCountries = new OldCountry[]{peru, argentina};
        peru.adjacentCountries = new OldCountry[]{newZealand, chile, argentina,
            brazil, colombiaVenezuela};
        colombiaVenezuela.adjacentCountries = new OldCountry[]{centralAmerica,
            peru, brazil, caribbeanAmerica};
        southAfrica.adjacentCountries = new OldCountry[]{nambiaBotswana,
            mozambiqueMadagascar};
        northAfrica.adjacentCountries = new OldCountry[]{spain, westernAfrica,
            middleAfrica, egypt, italy};
        centralAfrica.adjacentCountries = new OldCountry[]{middleAfrica,
            nambiaBotswana, mozambiqueMadagascar, easternAfrica};
        middleAfrica.adjacentCountries = new OldCountry[]{northAfrica,
            westernAfrica, atlanticAfrica, centralAfrica, easternAfrica, egypt
            };
        atlanticAfrica.adjacentCountries = new OldCountry[]{brazil,
            middleAfrica, westernAfrica};
        westernAfrica.adjacentCountries = new OldCountry[]{atlanticAfrica,
            middleAfrica, northAfrica};
        easternAfrica.adjacentCountries = new OldCountry[]{egypt, middleAfrica,
            centralAfrica, arabia};
        egypt.adjacentCountries = new OldCountry[]{northAfrica, middleAfrica,
            easternAfrica, arabia};
        mozambiqueMadagascar.adjacentCountries = new OldCountry[]{centralAfrica,
            nambiaBotswana, southAfrica};
        nambiaBotswana.adjacentCountries = new OldCountry[]{southAfrica,
            mozambiqueMadagascar, centralAfrica};
        scandinavia.adjacentCountries = new OldCountry[]{easternGreenland,
            britain, germany, poland, moscow};
        britain.adjacentCountries = new OldCountry[]{easternGreenland,
            atlanticAmerica, france, scandinavia};
        france.adjacentCountries = new OldCountry[]{britain, spain, italy,
            germany, belgium};
        germany.adjacentCountries = new OldCountry[]{belgium, france, italy,
            austriaHungary, poland, scandinavia};
        spain.adjacentCountries = new OldCountry[]{northAfrica, france};
        italy.adjacentCountries = new OldCountry[]{france, northAfrica, greece,
            austriaHungary, germany};
        turkey.adjacentCountries = new OldCountry[]{greece, arabia, moscow};
        poland.adjacentCountries = new OldCountry[]{scandinavia, germany,
            austriaHungary, moscow};
        belgium.adjacentCountries = new OldCountry[]{france, germany};
        austriaHungary.adjacentCountries = new OldCountry[]{germany, italy,
            greece, poland};
        moscow.adjacentCountries = new OldCountry[]{scandinavia, poland, turkey,
            kazakhstan, ural};
        greece.adjacentCountries = new OldCountry[]{austriaHungary, italy, turkey
            };
        // -OldCountry Bomb/Nuclear Weapon Range Lists-
        /*
         * Each country's list of countries it can hit with bombs and nuclear
         * weapons
         */
        ural.bombingRangeCountries = new OldCountry[]{moscow, kazakhstan,
            centralAsia, northernChina, mongolia, southernSiberia,
            northernSiberia};
        northernSiberia.bombingRangeCountries = new OldCountry[]{ural, mongolia,
            southernSiberia, sakha};
        southernSiberia.bombingRangeCountries = new OldCountry[]{ural,
            kazakhstan, mongolia, northernChina, korea, sakha, northernSiberia
            };
        sakha.bombingRangeCountries = new OldCountry[]{northernSiberia,
            southernSiberia, mongolia, northernChina, korea, japan,
            easternRussia};
        easternRussia.bombingRangeCountries = new OldCountry[]{sakha, alaska,
            japan};
        northernChina.bombingRangeCountries = new OldCountry[]{ural, kazakhstan,
            centralAsia, india, southeastAsia, southernChina, japan, korea,
            sakha, mongolia};
        southernChina.bombingRangeCountries = new OldCountry[]{mongolia,
            northernChina, india, southeastAsia, indonesia, japan, korea};
        japan.bombingRangeCountries = new OldCountry[]{sakha, korea,
            northernChina, southernChina, pacificAmerica, easternRussia};
        korea.bombingRangeCountries = new OldCountry[]{northernChina,
            southernChina, japan, sakha};
        mongolia.bombingRangeCountries = new OldCountry[]{ural, kazakhstan,
            centralAsia, india, northernChina, southernChina, korea, sakha,
            southernSiberia};
        kazakhstan.bombingRangeCountries = new OldCountry[]{moscow, poland,
            austriaHungary, greece, turkey, arabia, centralAsia, india,
            northernChina, mongolia, ural};
        indonesia.bombingRangeCountries = new OldCountry[]{india,
            westernAustralia, queensland, southernChina, southeastAsia};
        india.bombingRangeCountries = new OldCountry[]{kazakhstan, centralAsia,
            arabia, southeastAsia, southernChina, northernChina};
        arabia.bombingRangeCountries = new OldCountry[]{turkey, austriaHungary,
            greece, italy, egypt, middleAfrica, easternAfrica, centralAfrica,
            india, centralAsia, kazakhstan, moscow};
        centralAsia.bombingRangeCountries = new OldCountry[]{moscow, turkey,
            egypt, arabia, india, northernChina, mongolia, kazakhstan};
        southeastAsia.bombingRangeCountries = new OldCountry[]{india, indonesia,
            japan, southernChina, northernChina};
        westernAustralia.bombingRangeCountries = new OldCountry[]{indonesia,
            tasmania, queensland};
        tasmania.bombingRangeCountries = new OldCountry[]{westernAustralia,
            newZealand, queensland};
        queensland.bombingRangeCountries = new OldCountry[]{indonesia,
            westernAustralia, tasmania, newZealand};
        newZealand.bombingRangeCountries = new OldCountry[]{queensland, tasmania,
            peru};
        centralAmerica.bombingRangeCountries = new OldCountry[]{mexico, peru,
            colombiaVenezuela, caribbeanAmerica, atlanticAmerica};
        caribbeanAmerica.bombingRangeCountries = new OldCountry[]{
            atlanticAmerica, middleAmerica, mexico, centralAmerica,
            colombiaVenezuela};
        mexico.bombingRangeCountries = new OldCountry[]{pacificAmerica,
            centralAmerica, colombiaVenezuela, caribbeanAmerica,
            atlanticAmerica, middleAmerica, westernCanada};
        middleAmerica.bombingRangeCountries = new OldCountry[]{yukonCanada,
            westernCanada, pacificAmerica, mexico, centralAmerica,
            caribbeanAmerica, atlanticAmerica, easternCanada};
        pacificAmerica.bombingRangeCountries = new OldCountry[]{alaska, japan,
            mexico, middleAmerica, westernCanada, yukonCanada};
        atlanticAmerica.bombingRangeCountries = new OldCountry[]{westernCanada,
            middleAmerica, mexico, centralAmerica, colombiaVenezuela,
            caribbeanAmerica, easternCanada, britain};
        easternCanada.bombingRangeCountries = new OldCountry[]{nunavut,
            westernCanada, middleAmerica, pacificAmerica, easternGreenland,
            westernGreenland, atlanticAmerica};
        westernCanada.bombingRangeCountries = new OldCountry[]{yukonCanada,
            alaska, pacificAmerica, middleAmerica, atlanticAmerica,
            easternCanada, nunavut};
        yukonCanada.bombingRangeCountries = new OldCountry[]{alaska,
            westernCanada, pacificAmerica, middleAmerica, easternCanada,
            nunavut};
        nunavut.bombingRangeCountries = new OldCountry[]{yukonCanada,
            westernCanada, middleAmerica, easternCanada, easternGreenland,
            westernGreenland};
        easternGreenland.bombingRangeCountries = new OldCountry[]{
            westernGreenland, easternCanada, britain, scandinavia};
        westernGreenland.bombingRangeCountries = new OldCountry[]{nunavut,
            easternCanada, easternGreenland};
        alaska.bombingRangeCountries = new OldCountry[]{easternRussia,
            pacificAmerica, westernCanada, yukonCanada};
        brazil.bombingRangeCountries = new OldCountry[]{caribbeanAmerica,
            colombiaVenezuela, centralAmerica, peru, chile, argentina,
            atlanticAfrica};
        argentina.bombingRangeCountries = new OldCountry[]{peru, chile, brazil,
            colombiaVenezuela};
        chile.bombingRangeCountries = new OldCountry[]{argentina, brazil,
            colombiaVenezuela, peru};
        peru.bombingRangeCountries = new OldCountry[]{centralAmerica, chile,
            argentina, brazil, colombiaVenezuela, caribbeanAmerica,
            newZealand};
        colombiaVenezuela.bombingRangeCountries = new OldCountry[]{
            caribbeanAmerica, mexico, peru, brazil, centralAmerica,
            atlanticAmerica};
        southAfrica.bombingRangeCountries = new OldCountry[]{nambiaBotswana,
            mozambiqueMadagascar, centralAfrica};
        northAfrica.bombingRangeCountries = new OldCountry[]{westernAfrica,
            atlanticAfrica, middleAfrica, easternAfrica, egypt, arabia,
            turkey, poland, austriaHungary, greece, germany, italy, belgium,
            france, spain, britain};
        centralAfrica.bombingRangeCountries = new OldCountry[]{westernAfrica,
            atlanticAfrica, nambiaBotswana, southAfrica,
            mozambiqueMadagascar, easternAfrica, arabia, middleAfrica, egypt};
        middleAfrica.bombingRangeCountries = new OldCountry[]{northAfrica,
            westernAfrica, atlanticAfrica, centralAfrica, nambiaBotswana,
            southAfrica, westernAfrica, arabia, turkey, italy, greece,
            easternAfrica, egypt};
        atlanticAfrica.bombingRangeCountries = new OldCountry[]{brazil,
            middleAfrica, centralAfrica, northAfrica, westernAfrica};
        westernAfrica.bombingRangeCountries = new OldCountry[]{atlanticAfrica,
            middleAfrica, centralAfrica, easternAfrica, egypt, poland, italy,
            france, spain, northAfrica};
        easternAfrica.bombingRangeCountries = new OldCountry[]{egypt, italy,
            northAfrica, westernAfrica, middleAfrica, centralAfrica,
            nambiaBotswana, mozambiqueMadagascar, centralAsia, arabia,
            turkey, poland, italy, };
        egypt.bombingRangeCountries = new OldCountry[]{poland, germany,
            austriaHungary, greece, turkey, italy, northAfrica,
            westernAfrica, middleAfrica, easternAfrica, arabia};
        mozambiqueMadagascar.bombingRangeCountries = new OldCountry[]{
            easternAfrica, middleAfrica, centralAfrica, nambiaBotswana,
            southAfrica};
        nambiaBotswana.bombingRangeCountries = new OldCountry[]{easternAfrica,
            middleAfrica, centralAfrica, southAfrica, mozambiqueMadagascar};
        scandinavia.bombingRangeCountries = new OldCountry[]{easternGreenland,
            britain, belgium, france, spain, germany, italy, greece,
            austriaHungary, poland, moscow};
        britain.bombingRangeCountries = new OldCountry[]{easternGreenland,
            atlanticAmerica, spain, france, italy, austriaHungary, germany,
            belgium, scandinavia};
        france.bombingRangeCountries = new OldCountry[]{britain, spain,
            northAfrica, italy, belgium, germany, austriaHungary, greece,
            poland, scandinavia};
        germany.bombingRangeCountries = new OldCountry[]{belgium, france, spain,
            britain, northAfrica, italy, egypt, turkey, greece,
            austriaHungary, poland, moscow, scandinavia};
        spain.bombingRangeCountries = new OldCountry[]{britain, austriaHungary,
            greece, italy, germany, france, belgium, northAfrica,
        westernAfrica};
        italy.bombingRangeCountries = new OldCountry[]{northAfrica,
            westernAfrica, egypt, middleAfrica, greece, turkey,
            austriaHungary, poland, moscow, france, belgium, scandinavia,
            britain, spain, germany};
        turkey.bombingRangeCountries = new OldCountry[]{poland, austriaHungary,
            greece, germany, italy, moscow, northAfrica, egypt, middleAfrica,
            easternAfrica, arabia, centralAsia, kazakhstan};
        poland.bombingRangeCountries = new OldCountry[]{scandinavia, moscow,
            germany, austriaHungary, greece, turkey, belgium, france, egypt,
            kazakhstan, italy};
        belgium.bombingRangeCountries = new OldCountry[]{scandinavia, britain,
            france, spain, germany, italy, austriaHungary, greece, poland};
        austriaHungary.bombingRangeCountries = new OldCountry[]{moscow, turkey,
            poland, greece, italy, germany, belgium, france, spain,
            scandinavia, northAfrica, egypt};
        moscow.bombingRangeCountries = new OldCountry[]{scandinavia, poland,
            austriaHungary, belgium, germany, italy, egypt, turkey, arabia,
            centralAsia, kazakhstan, ural, greece};
        greece.bombingRangeCountries = new OldCountry[]{turkey, moscow, poland,
            austriaHungary, italy, germany, belgium, france, egypt,
            northAfrica, middleAfrica, arabia};

        // --OldCountry and OldPlayer Lists--
        // -Countries List-
        // Copying each continent into countries list
        System.arraycopy(asia, 0, countries, 0, 16);
        System.arraycopy(oceania, 0, countries, 16, 4);
        System.arraycopy(northAmerica, 0, countries, 20, 13);
        System.arraycopy(southAmerica, 0, countries, 33, 5);
        System.arraycopy(africa, 0, countries, 38, 10);
        System.arraycopy(europe, 0, countries, 48, 12);
        // -OldPlayer Lists-
        // Various player lists with different players included
        ArrayList<OldPlayer> playersWithNeutral = new ArrayList<OldPlayer>();
        ArrayList<OldPlayer> players = new ArrayList<OldPlayer>();
        ArrayList<OldPlayer> playersRemaining = new ArrayList<OldPlayer>();
        ArrayList<OldPlayer> playersRemainingWithNeutral;

        // --OldCountry Owners--
        // Every country is neutral to begin
        for(OldCountry country : countries){
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
            monitor and enter fullscreen mode.\n""");
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
            scrolling.\n""");
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
            [1] 1, 234, 567
            [2] 1.234.567
            [3] 1 234 567""");
        numFormat = (int) getNum(1, 3);
        clearScreen();

        // WEBSITE LINK
        // Link to Kingdom of War - Global Conquest website
        System.out.println("""
            Here is this game's website.
            NOT AVAILABLE
            This website has all the game's rules, so it is
            suggested that you open it.\n""");
            delayedClearScreen();

        // INTRO SCREEN
        // Prints intro screen, which is a certain map
        printMap(3);
        System.out.println();
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
                // -OldPlayer Creation-
                clearScreen();
                // Getting number of players
                System.out.println("How many players are there (max. 6)?");
                // Initial Creation
                numPlayers = (int) getNum(2, 6);
                OldPlayer player1 = new OldPlayer(false, "", '-');
                players.add(player1);
                playersWithNeutral.add(player1);
                playersRemaining.add(player1);
                OldPlayer player2 = new OldPlayer(false, "", '-');
                players.add(player2);
                playersWithNeutral.add(player2);
                playersRemaining.add(player2);
                if(numPlayers >= 3){
                    OldPlayer player3 = new OldPlayer(false, "", '-');
                    players.add(player3);
                    playersWithNeutral.add(player3);
                    playersRemaining.add(player3);
                    if(numPlayers >= 4){
                        OldPlayer player4 = new OldPlayer(false, "", '-');
                        players.add(player4);
                        playersWithNeutral.add(player4);
                        playersRemaining.add(player4);
                        if(numPlayers >= 5){
                            OldPlayer player5 = new OldPlayer(false, "", '-');
                            players.add(player5);
                            playersWithNeutral.add(player5);
                            playersRemaining.add(player5);
                            if(numPlayers == 6){
                                OldPlayer player6 = new OldPlayer(false, "", '-');
                                players.add(player6);
                                playersWithNeutral.add(player6);
                                playersRemaining.add(player6);
                            }
                        }
                    }
                }
                ArrayList<String> availableColors = new ArrayList<String>(
                    Arrays.asList(
                    "Red", "Yellow", "Green", "Blue", "Purple", "Pink"));
                for(OldPlayer player : players){
                    clearScreen();
                    // OldPlayer's Name
                    System.out.println("OldPlayer " +
                        (players.indexOf(player) + 1) + """
                        
                        What is this player's name?
                        Names cannot contain pipes (| symbol).""");
                    player.name = scanner.nextLine().replace("|", "");
                    // Is OldPlayer a Bot
                    System.out.println("""
                        \nIs this player a bot (controlled by the game)?
                        [1] Yes
                        [2] No""");
                    if(getNum(1, 2) == 1){
                        player.bot = true;
                    }
                    // OldPlayer's Color (for Text and Map Printing)
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
                            player.textColor = "\u001b[38;5;87;1m";
                            break;
                        case "Purple":
                            player.color = PURPLE_COLOR_LIST;
                            player.textColor = "\u001b[38;5;57;1m";
                            break;
                        case "Pink":
                            player.color = PINK_COLOR_LIST;
                            player.textColor = "\u001b[38;5;213;1m";
                            break;
                    }
                    availableColors.remove(color);
                }
                clearScreen();
                // -OldCountry Choosing-
                ArrayList<OldCountry> availableCountries =
                    new ArrayList<OldCountry>(Arrays.asList(countries));
                System.out.println("""
                    Each player must now choose a country to start in.
                    How would you like countries to be chosen?
                    [1] Players are randomly assigned countries
                    [2] Players choose their countries""");
                if(getNum(1, 2) == 1){
                    // Randomly Assigning Countries
                    clearScreen();
                    for(OldPlayer player : players){
                        OldCountry country = availableCountries.get(
                            random.nextInt(availableCountries.size()));
                        country.owner = player;
                        availableCountries.remove(country);
                        for(OldCountry adjacentCountry :
                        country.adjacentCountries){
                            // Players cannot have adjacent countries
                            availableCountries.remove(adjacentCountry);
                        }
                        System.out.println(player.getColoredName() + " got " +
                            country.getColoredName() +
                            " as their country.\n");
                    }
                    delayedClearScreen();
                }else{
                    // Players Chose Their OldCountry
                    clearScreen();
                    for(OldPlayer player : randomizeList(players)){
                        if(player.bot){
                            // OldPlayer is a Bot
                            /*
                             * Methodology:
                             * Bot splits map into a number of regions based
                             * on number of players, chooses fairly central
                             * country in region.
                             */
                            switch(numPlayers){
                                case 2:
                                    // There Are Two Players
                                    OldCountry[] northwestCountries =
                                        new OldCountry[30];
                                    System.arraycopy(northAmerica, 0,
                                        northwestCountries, 0, 13);
                                    System.arraycopy(southAmerica, 0,
                                        northwestCountries, 13, 5);
                                    System.arraycopy(europe, 0,
                                        northwestCountries, 18, 12);
                                    boolean northwestOccupied = false;
                                    for(OldCountry country : northwestCountries){
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
                                    OldCountry[] westCountries = new OldCountry[18];
                                    System.arraycopy(northAmerica, 0,
                                        westCountries, 0, 13);
                                    System.arraycopy(southAmerica, 0,
                                        westCountries, 13, 5);
                                    OldCountry[] centralCountries =
                                        new OldCountry[22];
                                    System.arraycopy(europe, 0,
                                        centralCountries, 0, 12);
                                    System.arraycopy(africa, 0,
                                        centralCountries, 12, 10);
                                    boolean westOccupied = false;
                                    boolean centralOccupied = false;
                                    for(OldCountry country : westCountries){
                                        if(country.owner != playerNeutral){
                                            westOccupied = true;
                                            break;
                                        }
                                    }
                                    for(OldCountry country : centralCountries){
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
                                    OldCountry[] eastCountries = new OldCountry[20];
                                    System.arraycopy(asia, 0,
                                        eastCountries, 0, 16);
                                    System.arraycopy(oceania, 0,
                                        eastCountries, 16, 4);
                                    OldCountry[] southAmericaAfrica =
                                        new OldCountry[15];
                                    System.arraycopy(southAmerica, 0,
                                        southAmericaAfrica, 0, 5);
                                    System.arraycopy(africa, 0,
                                        southAmericaAfrica, 5, 10);
                                    boolean eastOccupied = false;
                                    boolean southAmericaAfricaOccupied =
                                        false;
                                    boolean europeOccupied = false;
                                    for(OldCountry country : eastCountries){
                                        if(country.owner != playerNeutral){
                                            eastOccupied = true;
                                            break;
                                        }
                                    }
                                    for(OldCountry country : southAmericaAfrica){
                                        if(country.owner != playerNeutral){
                                            southAmericaAfricaOccupied = true;
                                            break;
                                        }
                                    }
                                    for(OldCountry country : europe){
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
                                    OldCountry[] southAmericaOceania =
                                        new OldCountry[9];
                                    System.arraycopy(southAmerica, 0,
                                        southAmericaOceania, 0, 5);
                                    System.arraycopy(oceania, 0,
                                        southAmericaOceania, 5, 4);
                                    boolean asiaOccupied = false;
                                    boolean africaOccupied = false;
                                    europeOccupied = false;
                                    boolean southAmericaOceaniaOccupied =
                                        false;
                                    for(OldCountry country : asia){
                                        if(country.owner != playerNeutral){
                                            asiaOccupied = true;
                                            break;
                                        }
                                    }
                                    for(OldCountry country : africa){
                                        if(country.owner != playerNeutral){
                                            africaOccupied = true;
                                            break;
                                        }
                                    }
                                    for(OldCountry country : europe){
                                        if(country.owner != playerNeutral){
                                            europeOccupied = true;
                                            break;
                                        }
                                    }
                                    for(OldCountry country :
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
                                    for(OldCountry country : europe){
                                        if(country.owner != playerNeutral){
                                            europeOccupied = true;
                                            break;
                                        }
                                    }
                                    for(OldCountry country : africa){
                                        if(country.owner != playerNeutral){
                                            africaOccupied = true;
                                            break;
                                        }
                                    }
                                    for(OldCountry country : northAmerica){
                                        if(country.owner != playerNeutral){
                                            northAmericaOccupied = true;
                                            break;
                                        }
                                    }
                                    for(OldCountry country : asia){
                                        if(country.owner != playerNeutral){
                                            asiaOccupied = true;
                                            break;
                                        }
                                    }
                                    for(OldCountry country : southAmerica){
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
                        }else{
                            // Print Map to Show Options
                            printMap(1);
                            System.out.println(player.getColoredName() + """
                                , please choose a country on this map.
                                You cannot chose a country that has already
                                been chosen (is not grey) or a country next
                                to one that has already been chosen.""");
                            // OldPlayer Chooses
                            OldCountry country = getCountry(availableCountries);
                            country.owner = player;
                            clearScreen();
                        }
                        /*
                         * Remove Chosen OldCountry and Its Adjacent Countries
                         * From Available Countries
                         */
                        OldCountry country = player.getCountries()[0];
                        availableCountries.remove(country);
                        for(OldCountry adjacentCountry :
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
                boolean botChangeable = false;
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
                    // Can OldPlayer's Status as Human/Bot be Changed
                    clearScreen();
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
                    }
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
                player1 = new OldPlayer(false, "", '-');
                players.add(player1);
                playersWithNeutral.add(player1);
                playersRemaining.add(player1);
                player2 = new OldPlayer(false, "", '-');
                players.add(player2);
                playersWithNeutral.add(player2);
                playersRemaining.add(player2);
                if(numPlayers >= 3){
                    OldPlayer player3 = new OldPlayer(false, "", '-');
                    players.add(player3);
                    playersWithNeutral.add(player3);
                    playersRemaining.add(player3);
                    if(numPlayers >= 4){
                        OldPlayer player4 = new OldPlayer(false, "", '-');
                        players.add(player4);
                        playersWithNeutral.add(player4);
                        playersRemaining.add(player4);
                        if(numPlayers >= 5){
                            OldPlayer player5 = new OldPlayer(false, "", '-');
                            players.add(player5);
                            playersWithNeutral.add(player5);
                            playersRemaining.add(player5);
                            if(numPlayers == 6){
                                OldPlayer player6 = new OldPlayer(false, "", '-');
                                players.add(player6);
                                playersWithNeutral.add(player6);
                                playersRemaining.add(player6);
                            }
                        }
                    }
                }
                // OldPlayer Data
                for(OldPlayer player : players){
                    // OldPlayer's Name
                    player.name = gameCodes[i++].replace("|", "");
                    // Game codes from the website have no player names
                    while(player.name.equals("")){
                        System.out.println("OldPlayer " +
                            (players.indexOf(player) + 1) + """
                             does not appear to have a name.
                            What is their name?""");
                        player.name = scanner.nextLine().replace("|", "");
                        clearScreen();
                    }
                    // Is OldPlayer Still Playing
                    if(! gameCodes[i++].equals("y")){
                        playersRemaining.remove(player);
                    }
                    // Is OldPlayer a Bot
                    String isBot = gameCodes[i++];
                    if(isBot.equals("m")){
                        // OldPlayer Might be a Bot
                        System.out.println("OldPlayer " +
                            (players.indexOf(player) + 1) + """
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
                            // OldPlayer is a Bot
                            player.bot = true;
                        }
                        if(botChangeable){
                            // OldPlayer's Status as a Human/Bot can be Changed
                            System.out.print("OldPlayer " +
                                (players.indexOf(player) + 1) + " is a ");
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
                                // OldPlayer Becomes Opposite
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
                    }
                    // OldPlayer's Color
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
                     * OldPlayer's Money, Morale, Reserve Soldiers, Bombs, and
                     * Nuclear Weapons
                     */
                    player.money = Integer.parseInt(gameCodes[i++]);
                    player.morale = Double.parseDouble(gameCodes[i++]);
                    player.reserveSoldiers = Integer.parseInt(gameCodes[i++]);
                    player.bombs = Integer.parseInt(gameCodes[i++]);
                    player.nuclearWeapons = Integer.parseInt(gameCodes[i++]);
                    char[] countryList = gameCodes[i++].toCharArray();
                    for(char abbrv : countryList){
                        for(OldCountry country : countries){
                            if(country.abbrvShort == abbrv){
                                country.owner = player;
                                break;
                            }
                        }
                    }
                }
                // OldCountry Data
                for(OldCountry country : countries){
                    // OldCountry's Soldiers
                    country.soldiers = Integer.parseInt(gameCodes[i++]);
                }
                // Does OldCountry Have the Virus
                String virusCountries = gameCodes[i++];
                // Does OldCountry Have Fallout
                String falloutCountries = gameCodes[i++];
                for(OldCountry country : countries){
                    if(virusCountries.indexOf(country.abbrvShort) != -1){
                        country.virus = true;
                    }
                    if(falloutCountries.indexOf(country.abbrvShort) != -1){
                        country.fallout = true;
                    }
                }
                // Game Code Loading Finished
                System.out.println("Game code loaded successfully.\n");
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
                    controlling countries or continents. It is usually
                    set at 200, but can be changed. It is recommended
                    to make it around the population of an average
                    country in your game.
                    Base gain:""" + " ");
                baseGain = (int) getNum(1, 1_000_000_000);
                gameCode += baseGain + "|";
                // Creating Players
                player1 = new OldPlayer(false, "", '-');
                players.add(player1);
                playersWithNeutral.add(player1);
                playersRemaining.add(player1);
                player2 = new OldPlayer(false, "", '-');
                players.add(player2);
                playersWithNeutral.add(player2);
                playersRemaining.add(player2);
                if(numPlayers >= 3){
                    OldPlayer player3 = new OldPlayer(false, "", '-');
                    players.add(player3);
                    playersWithNeutral.add(player3);
                    playersRemaining.add(player3);
                    if(numPlayers >= 4){
                        OldPlayer player4 = new OldPlayer(false, "", '-');
                        players.add(player4);
                        playersWithNeutral.add(player4);
                        playersRemaining.add(player4);
                        if(numPlayers >= 5){
                            OldPlayer player5 = new OldPlayer(false, "", '-');
                            players.add(player5);
                            playersWithNeutral.add(player5);
                            playersRemaining.add(player5);
                            if(numPlayers == 6){
                                OldPlayer player6 = new OldPlayer(false, "", '-');
                                players.add(player6);
                                playersWithNeutral.add(player6);
                                playersRemaining.add(player6);
                            }
                        }
                    }
                }
                // OldPlayer Data
                availableColors = new ArrayList<String>(Arrays.asList(
                    "Red", "Yellow", "Green", "Blue", "Purple", "Pink"));
                for(OldPlayer player : players){
                    clearScreen();
                    // OldPlayer's Name
                    System.out.println("OldPlayer " +
                        (players.indexOf(player) + 1) + """
                        
                        What is this player's name?
                        Names cannot contain pipes (| symbol).
                        If you are making a game code, blank names
                        can be replaced when the game code is loaded.""");
                    player.name = scanner.nextLine().replace("|", "");
                    gameCode += player.name + "|";
                    // Is OldPlayer Stil Playing (Always True/Yes)
                    gameCode += "y|";
                    // Is OldPlayer a Bot
                    System.out.println("""
                        \nIs this player a bot (controlled by the game)?
                        [1] Yes
                        [2] No""");
                    if(getNum(1, 2) == 1){
                        player.bot = true;
                        gameCode += "y|";
                    }else{
                        gameCode += "n|";
                    }
                    // OldPlayer's Color (for Text and Map Printing)
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
                    // OldPlayer's Money
                    System.out.println("""
                        \nHow much money does this player have?
                        Regular games start with $""" + formatNum(1000) +
                        ",\nbut a custom game could have any amount.");
                    player.money = getNum(0, 2_000_000_000);
                    gameCode += player.money + "|";
                    // OldPlayer's Morale
                    System.out.println("""
                        \nWhat is this player's current morale level?
                        Regular games start with 50, but custom games can
                        have any positive amount up to 100.""");
                    player.morale = getNum(0, 100);
                    gameCode += player.morale + "|";
                    // OldPlayer's Reserve Soldiers
                    System.out.println("""
                        \nHow many reserve soldiers does this player have?
                        Regular games start with 0.""");
                    player.reserveSoldiers = (int) getNum(0, 1_000_000_000);
                    gameCode += player.reserveSoldiers + "|";
                    // OldPlayer's Bombs
                    System.out.println("""
                        \nHow many bombs does this player have?
                        Regular games start with 0.""");
                    player.bombs = (int) getNum(0, 1_000_000_000);
                    gameCode += player.bombs + "|";
                    // OldPlayer's Nuclear Weapons
                    System.out.println("""
                        \nHow many nuclear weapons does this player have?
                        Regular games start with 0.""");
                    player.nuclearWeapons = (int) getNum(0, 1_000_000_000);
                    gameCode += player.nuclearWeapons + "|";
                    // OldPlayer's Countries
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
                    if(players.indexOf(player) < players.size() - 1){
                        numAvailableCountries -= 1;
                    }
                    int numCountries = (int) getNum(1, numAvailableCountries);
                    // Getting Individual Countries
                    for(i = 0; i < numCountries; i++){
                        clearScreen();
                        printMap(1);
                        System.out.print("OldCountry " + (i + 1) + ": ");
                        OldCountry country = getCountry(new ArrayList<OldCountry>(
                            Arrays.asList(playerNeutral.getCountries())));
                        country.owner = player;
                        gameCode += country.abbrvShort;
                    }
                    gameCode += "|";
                    clearScreen();
                }
                // OldCountry Data
                // OldCountry's Soldiers
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
                        for(OldCountry country : countries){
                            country.soldiers = num;
                        }
                        break;
                    case 2:
                        clearScreen();
                        // Neutral Countries
                        System.out.println("\nHow many soldiers does each" +
                            " neutral country have?");
                        num = (int) getNum(0, 1_000_000_000);
                        for(OldCountry country : playerNeutral.getCountries()){
                            country.soldiers = num;
                        }
                        // Non-Neutral Countries
                        System.out.println("""
                            \nHow many soldiers does each non-neutral country
                            have?""");
                        num = (int) getNum(0, 1_000_000_000);
                        List<OldCountry> nonneutralCountries = new ArrayList
                            <OldCountry>(Arrays.asList(countries));
                        for(OldCountry country : playerNeutral.getCountries()){
                            nonneutralCountries.remove(country);
                        }
                        for(OldCountry country : nonneutralCountries){
                            country.soldiers = num;
                        }
                        break;
                    case 3:
                        clearScreen();
                        // Neutral Countries
                        System.out.println("\nHow many soldiers does each" +
                            " neutral country have?");
                        num = (int) getNum(0, 1_000_000_000);
                        for(OldCountry country : playerNeutral.getCountries()){
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
                            new ArrayList<OldCountry>(Arrays.asList(countries));
                        for(OldCountry country : playerNeutral.getCountries()){
                            nonneutralCountries.remove(country);
                        }
                        for(OldCountry country : nonneutralCountries){
                            boolean bordersEnemy = false;
                            for(OldCountry adjacentCountry :
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
                        // Each OldCountry Individually
                        for(OldCountry country : countries){
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
                        System.out.print("OldCountry: ");
                        OldCountry country = getCountry(
                            new ArrayList<OldCountry>(Arrays.asList(countries)));
                        System.out.print("Soldiers: ");
                        country.soldiers = getNum(0, 1_000_000_000);
                    }else{
                        break;
                    }
                }
                // Adding Each OldCountry to Game Code
                for(OldCountry country : countries){
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
                    new ArrayList<OldCountry>(Arrays.asList(countries));
                int numVirus = (int) getNum(0, 60);
                for(i = 0; i < numVirus; i++){
                    clearScreen();
                    printMap(2);
                    System.out.print("OldCountry " + (i + 1) + ": ");
                    OldCountry country = getCountry(availableCountries);
                    country.virus = true;
                    availableCountries.remove(country);
                    gameCode += country.abbrvShort;
                }
                gameCode += "|";
                clearScreen();
                // Countries With Fallout
                printMap(2);
                System.out.println("""
                    How many countries have radioactive waste/fallout?
                    Normal games start with none. Fallout is a
                    possibility when a country is hit by a nuclear
                    weapon.""");
                availableCountries =
                    new ArrayList<OldCountry>(Arrays.asList(countries));
                int numFallout = (int) getNum(0, 60);
                for(i = 0; i < numFallout; i++){
                    clearScreen();
                    printMap(2);
                    System.out.print("OldCountry " + (i + 1) + ": ");
                    OldCountry country = getCountry(availableCountries);
                    country.fallout = true;
                    availableCountries.remove(country);
                    gameCode += country.abbrvShort;
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

        // --Neutral OldPlayer Added to end of Lists--
        playersWithNeutral.add(playerNeutral);
        playersRemainingWithNeutral =
            new ArrayList<OldPlayer>(playersRemaining);
        playersRemainingWithNeutral.add(playerNeutral);

        // --Fill OldPlayer Holders--
        for(OldPlayer player : playersWithNeutral){
            for(int i = 0; i < 13; i++){
                player.holder.add((long) 0);
            }
        }

        // --Display Players' Info--
        // -OldPlayer Names-
        int maxLength = 0;
        int maxWidth = 12;
        for(OldPlayer player : playersRemainingWithNeutral){
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
            for(OldPlayer player : playersRemainingWithNeutral){
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
        String[] titles1= {"Bot/Human", "Money", "Morale", "Soldiers",
            "Countries"};
        // -Other-
        for(int i = 0; i < titles1.length; i++){
            System.out.print(titles1[i] +
                " ".repeat(9 - titles1[i].length()));
            String amount;
            for(OldPlayer player : playersRemainingWithNeutral){
                amount = "N/A";
                if(player != playerNeutral || i > 2){
                    switch(i){
                        case 0:
                            if(player.bot){
                                amount = "Bot";
                            }else{
                                amount = "Human";
                            }
                            break;
                        case 1:
                            amount = formatNum(player.money);
                            break;
                        case 2:
                            amount = formatDouble(player.morale, 1);
                            break;
                        case 3:
                            amount = formatNum(player.getSoldiers());
                            break;
                        case 4:
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
        System.out.println("\nDeath Total: " + formatNum(deathTotal) + "\n");
        delayedClearScreen();

        // --All Setup Finished, Print Map--
        printMap(1);
        System.out.println("""
            You are now ready to begin the game.
            Please ensure you have read the rules if you do
            not know how to play already. The rules are on the
            game's website here: ERROR NOT A WEBSITE LINK.\n""");
        delayedClearScreen();

        // MAIN GAME LOOP
        while(true){

            // --Turn Number--
            System.out.println("TURN " + turnNum + "\n");
            turnNum++;
            delayedClearScreen();

            // --Each OldPlayer's Original Stats--
            for(OldPlayer player : playersRemainingWithNeutral){
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
                 * 6 - Total Potential Power
                 * Regular Gains
                 * 7 - OldCountry Soldier Gains
                 * 8 - Continent Soldier Gains
                 * Morale Gains
                 * 9 - Money Gains
                 * 10 - Soldier Gains
                 * Virus and Fallout Losses
                 * 11 - Virus Soldier Losses
                 * 12 - Fallout Soldier Losses
                 */
                player.holder.set(0, player.money);
                player.holder.set(1, player.getSoldiers());
                player.holder.set(2, (long) (player.morale) * 10);
                player.holder.set(3, (long) player.getCountries().length);
                player.holder.set(4, (long) 0);
                for(OldCountry country : player.getCountries()){
                    player.holder.set(4, player.holder.get(4) + country.area);
                }
                player.holder.set(5, (long) (player.getSoldiers() / 1.25 +
                    player.bombs * 60 + player.nuclearWeapons * 75_000));
                player.holder.set(6, player.holder.get(5) +
                    (long) (player.money / 8.75));
            }

            // --Regular Soldier Gains--
            for(OldPlayer player : playersRemaining){
                // -OldCountry Gains-
                /*
                 * OldPlayer gains base gain (usually 200) more soldiers
                 * for each controlled country
                 */
                // Calculating Change
                long countryGains =
                    baseGain * (long) player.getCountries().length;
                // Adding Results
                player.reserveSoldiers += countryGains;
                player.holder.set(7, countryGains);
                // -Continent Gains-
                /*
                 * OldPlayer gains base gain * 0.75 (usually 150) more
                 * soldiers for each country in a controlled
                 * continent
                 */
                // Calculating Change
                long continentGains = 0;
                for(OldCountry[] continent : new OldCountry[][]{asia, oceania,
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
                player.holder.set(8, continentGains);
            }

            // --Morale Effects--
            for(OldPlayer player : playersRemaining){
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
                for(OldCountry country : player.getCountries()){
                    country.soldiers = (int)
                        Math.round(country.soldiers * soldierGainPercent);
                }
                player.reserveSoldiers = (long)
                    Math.round(player.reserveSoldiers * soldierGainPercent);
                /*
                 * Fixing Possible Rounding Problems
                 * 
                 * Example:
                 * OldPlayer 1 owns all countries. Each country and
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
                player.holder.set(9, player.money - player.holder.get(0));
                player.holder.set(10, player.getSoldiers() -
                    playerOriginalSoldiers);
            }

            // --Virus and Fallout Effects--
            // -Adding Slots to Players-
            for(OldPlayer player : playersRemainingWithNeutral){
                player.holder.set(11, (long) 0);
                player.holder.set(12, (long) 0);
            }
            // -Checking Whether Virus/Fallout is Present-
            boolean virusOrFalloutExists = false;
            for(OldCountry country : countries){
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
                OldCountry country = countries[random.nextInt(60)];
                while(country.soldiers == 0){
                    country = countries[random.nextInt(60)];
                }
                country.virus = true;
                virusOrFalloutExists = true;
                System.out.println("The " + GREEN_TEXT + "virus" +
                    ANSI_RESET + " spawned in " + country.getColoredName() +
                    ".\n");
                delayedClearScreen();
            }
            if(virusOrFalloutExists){
                // -Adding Elements to Holder-
                for(OldCountry country : countries){
                    if(country.virus){
                        // -OldCountry has the Virus-
                        // Soldier Loss
                        long soldierLoss =
                            Math.round(country.soldiers * 0.15);
                        country.soldiers -= soldierLoss;
                        deathTotal += soldierLoss;
                        country.owner.holder.set(
                            11, country.owner.holder.get(11) - soldierLoss);
                    }
                    if(country.fallout){
                        // -OldCountry has Fallout-
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
            for(OldPlayer player : playersRemaining){
                // Virus
                player.addMorale(20 * (player.holder.get(11) /
                    (player.holder.get(1) + player.holder.get(7) +
                    player.holder.get(8) + player.holder.get(10))));
                // Fallout
                player.addMorale(20 * (player.holder.get(11) /
                    (player.holder.get(1) + player.holder.get(7) +
                    player.holder.get(8) + player.holder.get(10))));
            }

            // --Total Gains--
            System.out.println("TOTAL GAINS\n");
            // -OldPlayer Names-
            maxLength = 0;
            maxWidth = 12;
            // Calculating width of columns
            for(OldPlayer player : playersRemainingWithNeutral){
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
                for(OldPlayer player : playersRemainingWithNeutral){
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
                "From Owning Continents", "MORALE GAINS", "Money", "Soldiers",
                "VIRUS AND FALLOUT LOSSES", "Virus", "Fallout", "TOTAL GAINS",
                "Money", "Soldiers", "TOTAL", "Money", "Soldiers"};
            for(int i = 0; i < titles2.length; i++){
                if(Character.isUpperCase
                (titles2[i].charAt(titles2[i].length() - 1))){
                    System.out.println(titles2[i]);
                }else{
                    System.out.print(titles2[i] +
                        " ".repeat(24 - titles2[i].length()));
                    for(OldPlayer player : playersRemainingWithNeutral){
                        String amount;
                        if(i < 12){
                            int[] nums =
                                {0, 0, 1, 0, 7, 8, 0, 9, 10, 0, 11, 12};
                            amount = formatNum(player.holder.get(nums[i]));
                        }else if(i == 13){
                            amount = formatNum(player.holder.get(9));
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
                                    amount = RED_TEXT + " ".repeat(2 + maxWidth -
                                        amount.length()) + amount + ANSI_RESET;
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
            System.out.println();
            delayedClearScreen();

            // --Soldier Payment--
            System.out.println("SOLDIER PAYMENT\n");
            delayedClearScreen();
            int choice = 1;
            for(OldPlayer player : playersRemaining){
                if(player.bot){
                    // OldPlayer is a Bot
                    /*
                     * Methodology:
                     * Bot chooses $6, unless it cannot afford it, in which
                     * case it chooses the most expensive option it can.
                     */
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
                }else{
                    // -OldPlayer's Info-
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
                }
                // Morale Change
                double cost;
                switch(choice){
                    case 1:
                        cost = 0;
                    default:
                        cost = choice * 0.5 + 4;
                }
                player.addMorale(2 * (cost - 6) + 2);
                System.out.println();
                delayedClearScreen();
            }

            // --Money Spending--
            System.out.println("MONEY SPENDING\n");
            delayedClearScreen();
            for(OldPlayer player : randomizeList(playersRemaining)){
                System.out.println(player.getColoredName() +
                    "'s turn to spend money.\n");
                delayedClearScreen();
                if(player.bot){
                    // OldPlayer is a Bot
                    /*
                     * Methodology:
                     * Idk
                     */
                }else{
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
                        for(OldCountry country : player.getCountries()){
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
                                "] Clean Up Radioactive Waste - $" +
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
                                    "Not enough money.\n" + ANSI_RESET);
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
                                    "Not enough money.\n" + ANSI_RESET);
                                delayedClearScreen();
                            }
                        }else if(choice == 5 && playerHasVirus){
                            // Eradicate Virus
                            clearScreen();
                            printMap(2);
                            System.out.print("OldCountry: ");
                            ArrayList<OldCountry> availableCountries =
                                new ArrayList<OldCountry>(
                                Arrays.asList(player.getCountries()));
                            int ii = availableCountries.size();
                            for(i = 0; i < ii; i++){
                                if(! availableCountries.get(i).virus){
                                    availableCountries.remove(i);
                                    ii--;
                                    i--;
                                }
                            }
                            OldCountry country = getCountry(availableCountries);
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
                                    formatNum(country.soldiers * 2) + "\n");
                                delayedClearScreen();
                            }
                        }else if((choice == 5 && playerHasFallout) ||
                        (choice == 6 && playerHasVirus && playerHasFallout)){
                            // Radioactive Waste Clean-Up
                            clearScreen();
                            printMap(2);
                            System.out.print("OldCountry: ");
                            ArrayList<OldCountry> availableCountries =
                                new ArrayList<OldCountry>(
                                Arrays.asList(player.getCountries()));
                            int ii = availableCountries.size();
                            for(i = 0; i < ii; i++){
                                if(! availableCountries.get(i).fallout){
                                    availableCountries.remove(i);
                                    ii--;
                                    i--;
                                }
                            }
                            OldCountry country = getCountry(availableCountries);
                            if(player.money >= 500_000){
                                player.money -= 500_000;
                                country.fallout = false;
                                player.addMorale(2);
                            }else{
                                System.out.println(RED_TEXT +
                                    "Not enough money.\n" + ANSI_RESET);
                                delayedClearScreen();
                            }
                        }else{
                            clearScreen();
                            break;
                        }
                        clearScreen();
                    }
                }
            }

            // --Soldier Deployment--
            System.out.println("SOLDIER DEPLOYMENT\n");
            delayedClearScreen();
            for(OldPlayer player : randomizeList(playersRemaining)){
                System.out.println(player.getColoredName() +
                    "'s turn to deploy soldiers.\n");
                delayedClearScreen();
                if(player.bot){
                    // OldPlayer is a Bot
                    /*
                     * Methodology:
                     * Figure it out
                     */
                    System.out.println(player.getColoredName() + " had " +
                        formatNum(player.reserveSoldiers) +
                        " soldiers to deploy.");
                    System.out.println();
                    delayedClearScreen();
                }else{
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
                            OldCountry country = getCountry(
                                new ArrayList<OldCountry>(
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
                }
            }
            System.out.println("End of Soldier Deployment\n");
            delayedClearScreen();

            // --Warfare--
            System.out.println("WARFARE\n");
            delayedClearScreen();
            // Available Countries for Invasions List
            for(OldPlayer player : playersRemaining){
                player.availableCountries.clear();
                for(OldCountry country : player.getCountries()){
                    if(! player.availableCountries.contains(country)){
                        player.availableCountries.add(country);
                    }
                    for(OldCountry adjacentCountry : country.adjacentCountries){
                        if(! player.availableCountries
                        .contains(adjacentCountry)){
                            player.availableCountries.add(adjacentCountry);
                        }
                        for(OldCountry adjacentCountry2 :
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
            ArrayList<OldPlayer> playersToRemove = new ArrayList<OldPlayer>();
            while(passes < playersRemaining.size()){
                passes = 0;
                playersToRemove.clear();
                for(OldPlayer player : randomizeList(playersRemaining)){
                    if(player.getSoldiers() == 0 && player.bombs == 0 &&
                    player.nuclearWeapons == 0){
                        System.out.println(player.getColoredName() +
                            "'s turn is being skipped, as they\n" +
                            "have no armies, bombs, or nuclear weapons.\n");
                        passes++;
                        delayedClearScreen();
                        continue;
                    }
                    if(player.bot){
                        // OldPlayer is a Bot
                        /*
                        * Methodology:
                        * Figure it out
                        */
                    }else{
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
                            // Starting OldCountry
                            System.out.print("Starting country: ");
                            OldCountry startingCountry = getCountry(
                                new ArrayList<OldCountry>(
                                Arrays.asList(player.getCountries())));
                            ArrayList<OldCountry> options =
                                new ArrayList<OldCountry>();
                            options.addAll(player.availableCountries);
                            ArrayList<OldCountry> options2 =
                                new ArrayList<OldCountry>();
                            options2.addAll(options);
                            for(OldCountry option : options2){
                                if(! Arrays.asList
                                (startingCountry.adjacentCountries)
                                .contains(option)){
                                    options.remove(option);
                                }
                            }
                            // Target OldCountry
                            System.out.print("Target country: ");
                            OldCountry targetCountry = getCountry(options);
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
                                OldPlayer enemy = targetCountry.owner;
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
                                        playersToRemove.add(enemy);
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
                            // Starting OldCountry
                            System.out.print("Starting country: ");
                            OldCountry startingCountry = getCountry(
                                new ArrayList<OldCountry>(
                                Arrays.asList(player.getCountries())));
                            // Target OldCountry
                            System.out.print("Target country: ");
                            OldCountry targetCountry = getCountry(
                                new ArrayList<OldCountry>(Arrays.asList(
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
                            // Starting OldCountry
                            System.out.print("Starting country: ");
                            OldCountry startingCountry = getCountry(
                                new ArrayList<OldCountry>(
                                Arrays.asList(player.getCountries())));
                            // Target OldCountry
                            System.out.print("Target country: ");
                            OldCountry targetCountry = getCountry(
                                new ArrayList<OldCountry>(Arrays.asList(
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
                            for(OldCountry country :
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
                            for(OldCountry country :
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
                        System.out.println();
                        delayedClearScreen();
                    }
                    
                }
                // Remove Players With No Countries
                for(OldPlayer player : playersToRemove){
                    playersRemaining.remove(player);
                    playersRemainingWithNeutral.remove(player);
                }
                if(playersRemaining.size() == 1){
                    // End of Game
                    break;
                }
            }

            // --Morale Changes--
            for(OldPlayer player : playersRemaining){
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
            System.out.println("STATISTICS\n");
            delayedClearScreen();
            String[] titles3 = {"Money", "Soldiers", "Morale",
                "Countries", "Area", "Military Power",
                "Total Potential Power"};
            for(OldPlayer player : playersRemaining){
                System.out.println(player.getColoredName());
                for(int i = 0; i < 7; i++){
                    int ii = 1;
                    for(OldPlayer player2 : playersRemaining){
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
                                    for(OldCountry country :
                                    player.getCountries()){
                                        totalArea += country.area;
                                    }
                                    for(OldCountry country :
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
                                for(OldCountry country : player.getCountries()){
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
                System.out.println();
                delayedClearScreen();
            }

            // --Game End--
            if(playersRemaining.size() == 1){
                printMap(1);
                System.out.println(
                    playersRemaining.get(0).getColoredName() + GREEN_TEXT +
                    " " + 
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
        System.out.println("[ENTER]");
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
        String formattedNum = String.format("%,8d%n", num).strip();
        switch(numFormat){
            case 1:
                /*
                 * Number Format 1
                 * 1,234,567  -->  1, 234, 567
                 */
                return formattedNum.replace(",", ", ");
            case 2:
                /*
                 * Number Format 2
                 * 1,234,567  -->  1.234.567
                 */
                return formattedNum.replace(",", ".");
            case 3:
                /*
                 * Number Format 3
                 * 1,234,567  -->  1 234 567
                 */
                return formattedNum.replace(",", " ");
            default:
                /*
                 * Default Number Format
                 * 1234567 doesn't change
                 * For when the numFormat hasn't been set
                 */
                return String.valueOf(num);
        }
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
     * OldCountry objects.
     * <p>
     * @param choices - user's options
     * @return OldCountry chosen
     */
    public static OldCountry getCountry(ArrayList<OldCountry> choices){
        while(true){
            // Get Choice
            String choice = scanner.nextLine();
            for(OldCountry country : choices){
                if(country.name.equals(choice) ||
                country.abbrvLong.equals(choice)){
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
                OldCountry country = choices.get(i);
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
                String choiceString = scanner.nextLine();
                if(choiceString.toLowerCase().equals("all")){
                    return max;
                }
                choiceString = choiceString.replace("M", "000000");
                long choice = Long.parseLong(choiceString.replace(" ", "")
                    .replace(",", "").replace(".", ""));
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
     * Prints the map.
     * <p>
     * Prints the Kingdom of War - Global Conquest Map.
     * Prints normal or virus/radioactive waste map.
     * <p>
     * @param type - type of map, with 1 being normal,
     * 2 being virus/radioactive waste map, and 3 being
     * the intro screen
     */
    public static void printMap(int type){
        String newForegroundText = FOREGROUND_TEXT;
        int symbolNum = 0;
        if(type == 1 || type == 2){
            // If not Intro Map
            // Replacing "|xyz" Placeholders With Countries' Armies
            for(OldCountry country : countries){
                // Formatting Countries Into Four Character Strings
                /*
                 * Getting Three or Four Character Number Representation
                 * Ex. 1 952 635  -->  1.9M
                 */
                String formattedNum = "ALOT";
                if(country.soldiers < 10_000){
                    formattedNum = String.valueOf(country.soldiers);
                }else if(country.soldiers < 999_500){
                    formattedNum = Math.round(country.soldiers / 1000) + "K";
                }else{
                    String[] letters = {"M", "B", "T", "Q"};
                    for(int i = 0; i < 4; i++){
                        if(country.soldiers < 9.950 * Math.pow(1000, i + 2)){
                            formattedNum = (Math.round(country.soldiers /
                                Math.pow(10, (i * 3) + 5)) / 10.0) +
                                letters[i];
                            break;
                        }else if(country.soldiers < 999.5 *
                        Math.pow(1000, i + 2)){
                            formattedNum = (Math.round(country.soldiers /
                                Math.pow(1000, i + 2))) + letters[i];
                            break;
                        }
                    }
                }
                // Aligning Number
                if(country.numAlignment == 'l'){
                    // Align to Left
                    formattedNum += " ".repeat(4 - formattedNum.length());
                }else if(country.numAlignment == 'c'){
                    // Align to Center
                    String beforeNum = "";
                    String afterNum = "";
                    switch(formattedNum.length()){
                        case 1:
                            beforeNum = "  ";
                            afterNum = " ";
                            break;
                        case 2:
                            beforeNum = afterNum = " ";
                            break;
                        case 3:
                            beforeNum = " ";
                            break;
                    }
                    formattedNum =  beforeNum + formattedNum + afterNum;
                }else{
                    // Align to Right
                    formattedNum =
                        " ".repeat(4 - formattedNum.length()) + formattedNum;
                }
                // Replacing Placeholder With Result
                newForegroundText = newForegroundText
                    .replace("|" + country.abbrvLong, formattedNum);
            }
        }else{
            // Is Intro Map
            /*
             * Removing All Names and Placeholders by Removing all Letters and
             * Numbers
             */
            for(int i = 48; i < 123; i++){
                newForegroundText = newForegroundText.replace((char) i, ' ');
            }
            newForegroundText =
                newForegroundText.replace("|", " ").replace("-", " ");
            // Adding Extra Lines to Top
            System.out.println("\u001b[48;5;16m" + " ".repeat(54) +
                "Kingdom of War - Global Conquest " + version +
                " ".repeat(55) + "\n" + " ".repeat(61) +
                "v0.0 Released August 2023" + " ".repeat(62));
        }
        for(String code : BACKGROUND_CODES){
            if(code.equals("00000")){
                // Code for Newline
                symbolNum++;
                System.out.println(ANSI_RESET);
            }else if(type == 3 && code.equals("14800")){
                // Black Line at Bottom Replaced With Extra Line
                System.out.println("\u001b[48;5;16m" + " ".repeat(39) +
                "The above (unlabelled) map is an example of what the game" +
                " looks like." + " ".repeat(40) + ANSI_RESET);
                break;
            }else{
                // Number of Times A Background Pattern is Repeated
                int numCode = Integer.parseInt(code.substring(0, 3));
                // Code for Top Pixel (a space is 1 pixel wide and 2 tall)
                char topCode = code.charAt(3);
                // Code for Bottom Pixel
                char bottomCode = code.charAt(4);
                // OldCountry of Top and Bottom Pixels
                OldCountry topCountry = null;
                OldCountry bottomCountry = null;
                // Getting Top and Bottom Countries
                for(OldCountry country : countries){
                    if(country.abbrvShort == topCode){
                        topCountry = country;
                    }
                    if(country.abbrvShort == bottomCode){
                        bottomCountry = country;
                    }
                    if(topCountry != null && bottomCountry != null){
                        break;
                    }
                }
                // Color for Top and Bottom Pixels
                String backColor = "";
                String frontColor = "";
                // Top OldCountry, Back (background) Color
                if(topCountry == null){
                    // If Top OldCountry is Not a OldCountry
                    if(topCode == '0'){
                        // Black (for legend at bottom)
                        backColor = "16";
                    }else{
                        // Water
                        backColor = "20";
                    }
                }else{
                    switch(type){
                        case 1:
                            // Normal Map, OldCountry is Color of its Owner
                            backColor = String.valueOf(topCountry.owner.color
                                [topCountry.lightnessLevel]);
                            break;
                        case 2:
                            // Virus/Radioactive Waste Map
                            if(topCountry.virus && topCountry.fallout){
                                // Red - Virus and Radioactive Waste
                                backColor =
                                    RED_COLOR_LIST[topCountry.lightnessLevel];
                            }else if(topCountry.virus){
                                // Green - Virus
                                backColor = GREEN_COLOR_LIST
                                    [topCountry.lightnessLevel];
                            }else if(topCountry.fallout){
                                // Purple - Radioactive Waste
                                backColor = PURPLE_COLOR_LIST
                                    [topCountry.lightnessLevel];
                            }else{
                                // Grey - Neither
                                backColor = GREY_COLOR_LIST
                                    [topCountry.lightnessLevel];
                            }
                            break;
                        case 3:
                            // Intro Map, OldCountry has Predecided Color
                            // List of Countries of Each Color
                            OldCountry[] redCountries = {britain, france,
                                scandinavia, belgium, germany, poland,
                                austriaHungary, moscow, greece, turkey};
                            OldCountry[] yellowCountries = {westernAustralia,
                                queensland, tasmania, newZealand, indonesia,
                                southeastAsia, southernChina, northernChina,
                                india, centralAsia};
                            OldCountry[] greenCountries = {easternRussia, sakha,
                                korea, japan, alaska, yukonCanada, nunavut,
                                westernCanada, pacificAmerica, middleAmerica};
                            OldCountry[] purpleCountries = {caribbeanAmerica,
                                centralAmerica, colombiaVenezuela, peru,
                                brazil, argentina, centralAfrica,
                                middleAfrica, atlanticAfrica, westernAfrica};
                            // Setting Color Based on List OldCountry is in
                            if(Arrays.asList(redCountries)
                            .contains(topCountry)){
                                backColor =
                                    RED_COLOR_LIST[topCountry.lightnessLevel];
                            }else if(Arrays.asList(yellowCountries)
                            .contains(topCountry)){
                                backColor = YELLOW_COLOR_LIST
                                    [topCountry.lightnessLevel];
                            }else if(Arrays.asList(greenCountries)
                            .contains(topCountry)){
                                backColor = GREEN_COLOR_LIST
                                    [topCountry.lightnessLevel];
                            }else if(Arrays.asList(purpleCountries)
                            .contains(topCountry)){
                                backColor = PURPLE_COLOR_LIST
                                    [topCountry.lightnessLevel];
                            }else{
                                backColor = GREY_COLOR_LIST
                                    [topCountry.lightnessLevel];
                            }
                            break;
                    }
                }
                // Bottom OldCountry, Front (foreground) Color
                if(bottomCountry == null){
                    // If Top OldCountry is Not a OldCountry
                    if(bottomCode == '0'){
                        // Black (for legend at bottom)
                        frontColor = "16";
                    }else{
                        // Water
                        frontColor = "20";
                    }
                }else{
                    switch(type){
                        case 1:
                        // Normal Map, OldCountry is Color of its Owner
                            frontColor = String.valueOf(bottomCountry
                                .owner.color[bottomCountry.lightnessLevel]);
                            break;
                        case 2:
                        // Virus/Radioactive Waste Map
                            if(bottomCountry.virus && bottomCountry.fallout){
                                // Red - Virus and Radioactive Waste
                                frontColor = RED_COLOR_LIST
                                    [bottomCountry.lightnessLevel];
                            }else if(bottomCountry.virus){
                                // Green - Virus
                                frontColor = GREEN_COLOR_LIST
                                    [bottomCountry.lightnessLevel];
                            }else if(bottomCountry.fallout){
                                // Purple - Radioactive Waste
                                frontColor = PURPLE_COLOR_LIST
                                    [bottomCountry.lightnessLevel];
                            }else{
                                // Grey - Neither
                                frontColor = GREY_COLOR_LIST
                                    [bottomCountry.lightnessLevel];
                            }
                            break;
                        case 3:
                            // Intro Map, OldCountry has Predecided Color
                            // List of Countries of Each Color
                            OldCountry[] redCountries = {britain, france,
                                scandinavia, belgium, germany, poland,
                                austriaHungary, moscow, greece, turkey};
                            OldCountry[] yellowCountries = {westernAustralia,
                                queensland, tasmania, newZealand, indonesia,
                                southeastAsia, southernChina, northernChina,
                                india, centralAsia};
                            OldCountry[] greenCountries = {easternRussia, sakha,
                                korea, japan, alaska, yukonCanada, nunavut,
                                westernCanada, pacificAmerica, middleAmerica};
                            OldCountry[] purpleCountries = {caribbeanAmerica,
                                centralAmerica, colombiaVenezuela, peru,
                                brazil, argentina, centralAfrica,
                                middleAfrica, atlanticAfrica, westernAfrica};
                            // Setting Color Based on List OldCountry is in
                            if(Arrays.asList(redCountries)
                            .contains(bottomCountry)){
                                frontColor = RED_COLOR_LIST
                                    [bottomCountry.lightnessLevel];
                            }else if(Arrays.asList(yellowCountries)
                            .contains(bottomCountry)){
                                frontColor = YELLOW_COLOR_LIST
                                    [bottomCountry.lightnessLevel];
                            }else if(Arrays.asList(greenCountries)
                            .contains(bottomCountry)){
                                frontColor = GREEN_COLOR_LIST
                                    [bottomCountry.lightnessLevel];
                            }else if(Arrays.asList(purpleCountries)
                            .contains(bottomCountry)){
                                frontColor = PURPLE_COLOR_LIST
                                    [bottomCountry.lightnessLevel];
                            }else{
                                frontColor = GREY_COLOR_LIST
                                    [bottomCountry.lightnessLevel];
                            }
                            break;
                    }
                }
                // Printing Section of Map
                // Repeats while pattern of top and bottom colors repeat
                for(int i = 0; i < numCode; i++){
                    System.out.print("\u001b[48;5;" + backColor +
                        "m\u001b[38;5;" + frontColor + "m" +
                        newForegroundText.charAt(symbolNum + i));
                }
                // Symbol numbers increases by number of times pattern repeats
                symbolNum += numCode;
            }
        }
        if(type == 2){
            // Adding Legend to Virus/Fallout Map
            System.out.println("\u001b[48;5;16m" + " ".repeat(18) +
                "Green - Virus" + " ".repeat(34) + "Purple - Fallout" +
                " ".repeat(37) + "Red - Both" + " ".repeat(20) + ANSI_RESET);
        }
    }

    /**
     * Randomizes the order of elements in a list.
     * <p>
     * Randomizes the order of elements in a list,
     * returns result as a array. List and array both of
     * OldPlayer.
     * <p>
     * @param list - list to shuffle
     * @return shuffled list, as an array
     */
    public static OldPlayer[] randomizeList(ArrayList<OldPlayer> list){
        // Creates Empty Array
        OldPlayer[] shuffledArray = new OldPlayer[list.size()];
        for(OldPlayer player : list){
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

class OldCountry{
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
    String abbrvLong;
    char abbrvShort;
    OldPlayer owner;

    // Military
    long soldiers = 200;
    OldCountry[] adjacentCountries;
    OldCountry[] bombingRangeCountries;

    // Virus and Radioactive Fallout
    boolean virus = false;
    boolean fallout = false;

    // Other
    // Used in map printing
    int lightnessLevel;
    // Area of country on map in pixels
    int area;
    // Whether army number is aligned left, center, or right on printed map
    char numAlignment;

    // PASSED VARIABLES
    OldCountry(String name, String abbrvLong, char abbrvShort,
    int lightnessLevel, int area){
        this.name = name;
        this.abbrvLong = abbrvLong;
        this.abbrvShort = abbrvShort;
        this.lightnessLevel = lightnessLevel;
        this.area = area;
        if(Arrays.asList('h', 'r', 'u', 'v', 'E', 'I', 'M', 'S', 'U', 'X')
        .contains(abbrvShort)){
            // Countries Alligned Left
            this.numAlignment = 'l';
        }else if(Arrays.asList('l', 'y', 'J', 'K', 'R', '3', '6')
        .contains(abbrvShort)){
            // Countries Alligned Right
            this.numAlignment = 'r';
        }else{
            // Countries Alligned Center
            this.numAlignment = 'c';
        }
    }

    // METHODS

    public String getColoredName(){
        return this.owner.textColor + this.name + "\u001b[0m";
    }
}

class OldPlayer{
    // VARIABLES

    // Basics
    boolean bot;
    String name;
    String textColor;
    String[] color;

    // Resources
    long money = 1000;
    long reserveSoldiers = 0;
    double morale = 50;
    int bombs = 0;
    int nuclearWeapons = 0;

    // Holder
    // Holds temporary data
    ArrayList<Long> holder = new ArrayList<Long>();

    // Available Countries
    // Used in invasions
    ArrayList<OldCountry> availableCountries = new ArrayList<OldCountry>();

    // PASSED VARIABLES
    OldPlayer(boolean bot, String name, char color){
        this.bot = bot;
        this.name = name;
        switch(color){
            case 'r':
                this.color = OldKingdomOfWarGlobalConquest.RED_COLOR_LIST;
                break;
            case 'y':
                this.color = OldKingdomOfWarGlobalConquest.YELLOW_COLOR_LIST;
                break;
            case 'g':
                this.color = OldKingdomOfWarGlobalConquest.GREEN_COLOR_LIST;
                break;
            case 'b':
                this.color = OldKingdomOfWarGlobalConquest.BLUE_COLOR_LIST;
                break;
            case 'p':
                this.color = OldKingdomOfWarGlobalConquest.PURPLE_COLOR_LIST;
                break;
            case 'k':
                this.color = OldKingdomOfWarGlobalConquest.PINK_COLOR_LIST;
                break;
            case 'n':
                this.color = OldKingdomOfWarGlobalConquest.GREY_COLOR_LIST;
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
    public OldCountry[] getCountries(){
        // Count Total Countries
        int totCountries = 0;
        for(OldCountry country : OldKingdomOfWarGlobalConquest.countries){
            if(country.owner == this){
                totCountries++;
            }
        }
        // Create and Return List of Countries
        int i = 0;
        OldCountry[] resultCountries = new OldCountry[totCountries];
        for(OldCountry country : OldKingdomOfWarGlobalConquest.countries){
            if(country.owner == this){
                resultCountries[i++] = country;
            }
        }
        return resultCountries;
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
        // Soldiers Deployed to OldPlayer's Countries
        for(OldCountry country : this.getCountries()){
            total += country.soldiers;
        }
        // Soldiers in OldPlayer's Reserves
        total += this.reserveSoldiers;
        return total;
    }
}
