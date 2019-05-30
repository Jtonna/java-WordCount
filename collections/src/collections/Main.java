package collections;

import java.util.*;

public class Main
{
	public static void main(String[] args)
	{

		// Dogs dogArr[]
		// dogArr = new Dogs [5]
		Dogs dogArr[] = new Dogs[5];
		// in java arrays are fixed length, so we have to tell it how many elements it will have.

		// in java each element in my array HAS to be the same data type

		System.out.println("*** Arrays ***");
		dogArr[0] = new Dogs("German Shepard", 90, false);
		dogArr[1] = new Dogs("Pit Bull", 80, false);
		dogArr[2] = new Dogs("Springer", 50, false);
		dogArr[3] = new Dogs("Rat Dog", 12, true);
		dogArr[4] = new Dogs("Idk", 425, false);
		// dogArr[5] = new Dogs("Mutt", 15, true);
		// we cant have 6 elements because we stated it would be fine. compiler says okay but running it gets an out of bounds error.

		System.out.println("for loop");
		for (int i = 0; i < dogArr.length; i++){
			System.out.println(dogArr[i]);
		}

		System.out.println(Arrays.toString(dogArr));
		// console logs an array list

		// creates an array list
		System.out.println("*** Array List ***");
		ArrayList<Dogs> dogsArrayList = new ArrayList<Dogs>();
		dogsArrayList.addAll(Arrays.asList(dogArr));

		for (Dogs d : dogsArrayList)
		{
			System.out.println(d);
		}

		// gets the length of the array list above
		System.out.println("Size of unmodified array list" + dogsArrayList.size());


		System.out.println("*** Insert into array list ***");
		// inserts dog into the array list
		// google: java array list add
		dogsArrayList.add(2, new Dogs("Labrador", 75, false));
		dogsArrayList.forEach(d -> System.out.println(d));

		System.out.println("*** get size of array ***");
		// gets the length of the modefied array list
		System.out.println("Size od modefied array list " + dogsArrayList.size());

		// we can use dogsArrayList.remove(3) to remove from the list
		dogsArrayList.remove(3);

		// changning the array list
		Iterator<Dogs> iterator = dogsArrayList.iterator();
		while (iterator.hasNext())
		{
			Dogs tempDog = iterator.next();
			if (tempDog.isApartment())
			{
				System.out.println(tempDog);
			} else {
				// dogsArrayList.remove(tempDog);
			}
		}

		dogsArrayList.forEach(d -> System.out.println(d));
		// PrintLN not IN

		/// lets sort n array the java way
		System.out.println("**** Java way of sorting ****");
		
		// create comparator
		Collections.sort(dogsArrayList, new Comparator<Dogs>()
		{
			public int compare (Dogs o1, Dogs o2)
			{
				return o1.getBreed().compareToIgnoreCase(o2.getBreed());
				// this sorts it by breed alphabetically
			}
		});

		Collections.sort(dogsArrayList, new Comparator<Dogs>()
		{
			public int compare (Dogs o1, Dogs o2)
			{
				return o1.getAvgWeight() - o2.getAvgWeight();
				// this sorts it by average weight with the smallets on top.
				// heavies to smallest would be o2 - o1 
			}
		});

		// it stays in this order until we sort it again

		System.out.println("*** HashMap ***");
		// hashmaps - we dont know what order its in (has (key, value)) the key MUST be unique, but the value but be an object
		HashMap<Integer, Dogs> dogsHashMap = new HashMap<Integer, Dogs>();
		// lets add the array list to the map
		int hashCount = 0;
		for (Dogs d : dogsArrayList)
		{
			// we need a kay (integer)
			dogsHashMap.put(hashCount, d);
			//put (key, object)
			hashCount++;
		}
		dogsArrayList.clear();
		// will clear the array list and the information from computer memory
		System.out.println(dogsHashMap.get(3));
		// looks up the hashmap item with the key of 3
		dogsHashMap.remove(3);
		// remove key 3 from the map

		// lets print it out now (the entire hash map)

		for (Integer i : dogsHashMap.keySet())
		// loops throught the key set
		{
			System.out.println(" keyset loop: " + dogsHashMap.get(i));
			// created has map, filled it in with the array, remember we dont know hadhmap order. java puts it in most memory efficent order. we know what one it is by its key value (3).
		}

		// hashmaps dont have order, so it doesnt make sense to sort it unless we convert it into an array list. array lists have each element as a single object. when we sort the hashmap we make it an arry list.
		ArrayList<HashMap.Entry<Integer, Dogs>> sortedMap = new ArrayList<HashMap.Entry<Integer, Dogs>>();
		sortedMap.addAll(dogsHashMap.entrySet());
		// add all takes entire set in the hashmap and adds it to the array list. we dont know what order it goes into though.
		Collections.sort(sortedMap, new Comparator<Map.Entry<Integer, Dogs> >()
		// creates new comparator for hashmap entry?? Map instead of hashmap. Map is a generic type. when we use the class it is of type map.
		// "no better explination other than it is" - John Mitchell 5/29/2019/10:54AM PST
        {
            public int compare (HashMap.Entry<Integer, Dogs> o1, HashMap.Entry<Integer, Dogs> o2)
            {
                return o1.getValue().getAvgWeight() - o2.getValue().getAvgWeight();
            }
		});
		sortedMap.forEach(d -> System.out.println(d));
	}
}
