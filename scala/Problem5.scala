/**
  * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
  * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 **/

// vim: set ts=4 sw=4 et:
def getFactors(num: Long): List[Long] = {
  num match {
    case 1 => List(num)
    case n:Long => {
      var div:Long = 2
      while (num % div > 0)
        div = div + 1
      List(div) ++ getFactors(num/div)
    }
  }
}

def LCM(nums: List[Long]): Long = {
  nums.map(getFactors(_)).foldLeft(Map():Map[Long, List[Long]]) { (countMap, factors) => 
    val mapFactors = factors.groupBy( x => x )
    countMap.foldLeft(Map():Map[Long, List[Long]]) { (m, item) =>
      val value = mapFactors.get(item._1) match {
        case Some(factorList) if (factorList.size > item._2.size) => factorList
        case _ => item._2
      }
      m ++ Map(item._1 -> value)
    } ++ mapFactors.filterKeys(key => !countMap.keys.toList.contains(key))
  }.values.flatten.product
}

println(LCM((1.toLong to 20.toLong).toList))
