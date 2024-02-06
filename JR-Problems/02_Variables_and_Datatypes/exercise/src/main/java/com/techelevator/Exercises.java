package com.techelevator;

public class Exercises {

    /**
     * For the purposes of this exercise, the following naming rules are tested:
     *
     * Variable names:
     *  - must start with a lowercase character a-z.
     *  - underscore ('_') characters are not allowed.
     *  - dollar sign ('$') characters are not allowed.
     *  - must be at least two characters in length.
     *  - You are encouraged to create descriptive names and are required to camel case them as appropriate.
     *
     * Constant names:
     *  - must start with an uppercase character A-Z.
     *  - dollar sign ('$') characters are not allowed.
     *  - must be at least two characters in length.
     *  - You are encouraged to create descriptive names and are required to upper case them as appropriate.
     *
     * Due to practical limitations, camel case and pascal case are not tested other than checking the first
     * character of the name is lower case for variables and upper case for constants. Your instructor will
     * manually review your solution checking for the correct casing.
     */

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numRacc = 3;
		int numLeft = 2;
		int totalRaccoons = numRacc - numLeft;


        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numflower = 5;
		int numbees = 3;
		int lessbees = numflower - numbees;

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int lonepiggy = 1;
		int mysterypiggy = 1;
		int totalpiggys = lonepiggy + mysterypiggy;


        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int owls = 3;
		int moreowl = 2;
		int m0reowlss1tt1ng = owls + moreowl;



        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int w0rk1nbeavers = 2;
		int sw1mm3rb3aver = 1;
		int st1llw0rkb3av = w0rk1nbeavers - sw1mm3rb3aver;


        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int t00cans = 2;
		int twoc4ns = 1;
		int toocans0nl1mb = t00cans + twoc4ns;



        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
         */
		int sqUirrelies = 4;
		int t0talnUt5 = 2;
		int moresquirrelsthannuts = sqUirrelies - t0talnUt5;



        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double h1ltquarter = .25;
		double h1ltdime = .10;
		double h1lt2nicks = .10;
		double totalcentsmrshilthas = h1ltquarter + h1ltdime + h1lt2nicks;




        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int mrsbr1ers = 18;
		int mr5mAcAdam5 = 20;
		int mrsFl4nnerYs = 17;
		int mrshiltsFav1st = mrsbr1ers + mr5mAcAdam5 + mrsFl4nnerYs;



        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double mr2h1lts1yoyo = .24;
		double mr5h1lts2nd = .14;
		double mr5stotalyoyoh1lts = mr2h1lts1yoyo + mr5h1lts2nd;



		/* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int marshh1lt = 8;
		int marshh1ltsmol = 10;
		int t0tal5marshh1lt = marshh1lt + marshh1ltsmol;



        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int mrsH1ltsHAus = 29;
		int br3ckn0ckES = 17;
		int totalHAusminusES = mrsH1ltsHAus - br3ckn0ckES;



        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */
		double mrsh1lttotal1o = 10;
		double mrsh1lt3spends = 3;
		double mrsh1ltpencil = 2.50;
		double totalMoneyspent = mrsh1lt3spends + mrsh1ltpencil;
		double mrsh1ltspending = mrsh1lttotal1o - totalMoneyspent;



        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int totalJ0shc0l = 16;
		int looserj0sh = 7;
		int haVz3nowj0sh = totalJ0shc0l -looserj0sh;



        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int n33dsh3ll = 25;
		int m3GanhAs = 19;
		int m0resEa5h3lls = n33dsh3ll - m3GanhAs;



        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int brand = 17;
		int red = 8;
		int greenB = brand - red;



        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int b00kshelf = 38;
		int martApUt = 10;
		int m0reb00ks= b00kshelf + martApUt;


        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int bee1has = 6;
		int bee5s = 8;
		int maNyb33s = bee1has * bee5s;



        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double iceH1lt = .99;
		double douBleIce = .99;
		double twiceIce = iceH1lt + douBleIce;



        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int r0cktotal = 125;
		int hasr0ck = 64;
		int n33dsrock = r0cktotal - hasr0ck;



        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int mrzHIltmar = 38;
		int l0sthhit = 15;
		int marleft = mrzHIltmar - l0sthhit;

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int hiltsis = 78;
		int st0pgAs = 32;
		int m1lesLeft = hiltsis - st0pgAs;


		/* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int satShovemorn = 90;
		int satShovenafter = 45;
		int m1nutesShove = satShovemorn + satShovenafter;



        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		double bouGhtHOt = 6.00;
		double eachHot = 0.50;
		double h0ttotal = bouGhtHOt * eachHot;



        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int m0neyhAs = 50;
		int pen1lsNeed = 7;
		int bUgetIs =  m0neyhAs / pen1lsNeed;



        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int bufft0tal = 33;
		int orAnbuff = 20;
		int rEdbuff = bufft0tal - orAnbuff;



        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double gAve = 1.00;
		double cAndy = .54;
		double cHangeleft = gAve - cAndy;



        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int cUrrently = 13;
		int pLantMur = 12;
		int totAl3y = cUrrently + pLantMur;



        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int day1st = 24;
		int dAystot = 2;
		int tw1ceday = day1st *	dAystot;


        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int kImCus = 4;
		int g1veGum = 5;
		int gUmeAch = kImCus * g1veGum;



        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double dAnhas = 3.00;
		double boUghtdAn = 1.00;
		double leFtm0ney = dAnhas - boUghtdAn;



        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int lAke = 5;
		int pEopleLake = 3;
		int bOatlake = lAke * pEopleLake;



        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int e11en = 380;
		int lEg0s = 57;
		int l0stleg = e11en - lEg0s;



        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int aRt= 35;
		int bAkestill = 83;
		int n33dsbake = bAkestill - aRt;



        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int w11ly = 1400;
		int l00sey = 290;
		int sUmcray = w11ly - l00sey;



        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickPage = 10;
		int numPages = 22;
		int sTicktotal = stickPage * numPages;



        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double cUpCakes = 100;
		double sPansofSatin = 8;
		double eAchequal = cUpCakes / sPansofSatin;


        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int hAsmade = 47;
		int jAreach = 6;
		int disEqual = hAsmade / jAreach;
		int temp = disEqual * 6 ;
		int rEmain = hAsmade - temp;


        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int pr3pare = 59;
		int nEighbors = 8;
		int eachCrioss = pr3pare / nEighbors;
		int leftOver = eachCrioss * nEighbors;
		int mArian = pr3pare - leftOver;


        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int trAycook = 12;
		int oNetime = 276;
		int aTonetime = oNetime / trAycook;



        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int mAdepret = 480;
		int seRving = 12;
		int bIteSize = mAdepret / seRving;




        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int c00kies = 53;
		int lEfthome = 2;
		int tHird = 3;
		int oRphanedis = c00kies - lEfthome;
		int cookTotal = oRphanedis / tHird;


        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int cArrot = 74;
		int seRvEqual = 12;
		int carrotLeft = cArrot / seRvEqual;
		int unEat = carrotLeft * seRvEqual;
		int unEaten = cArrot - unEat;



        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int tEddytotal = 98;
		int sHelfdis = 7;
		int dIsequal = tEddytotal / sHelfdis;



        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int alBumtotal = 480;
		int aLreadyin = 20;
		int rEma1ning = alBumtotal / aLreadyin;



        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int cardTotal = 94;
		int b0xHold = 8;
		int disPlaced = cardTotal / b0xHold;
		int outOf = disPlaced * b0xHold;
		int canOut = cardTotal - outOf;


        /* Exercise 49
        49. The Milky Way galaxy contains 300 billion stars. The Andromeda galaxy
        contains 1 trillion stars. How many stars do the two galaxies contain combined?
        */
		long milkyWayStars = 300000000000L;
		long andromedaStars = 1000000000000L;
		long combinedStars = milkyWayStars + andromedaStars;

        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double bakeCross = 17;
		double sevenGuest = 7;
		double gUesteq = bakeCross / sevenGuest;




	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
		double billRate = 1 / 2.15;
		double jillRate = 1 / 1.90;
		double combinedRate = billRate + jillRate;
		int totalRooms = 5;
		double timeRequired = totalRooms / combinedRate;
     

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String firstName = "Grace";
		String lastName = "Hopper";
		String middleInitial = "B";
		String fullName = lastName + ", " + firstName + " " + middleInitial + ".";


	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		int totalDistance = 800 / 100 ;
		int distanceTraveled = 537 / totalDistance ;
		int percentageCompleted = distanceTraveled ;

	}

}
