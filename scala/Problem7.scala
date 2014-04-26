/**
  *  By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
  *  What is the 10001st prime number?
**/

def getNthPrime(nth: Int): Long = {
  (1 to nth-1).foldLeft(2.toLong)( (nthPrime, iter) => getNextPrime(nthPrime) )
}

def getNextPrime(p: Long): Long = {
  isPrime(p+1) match {
    case false =>  getNextPrime(p+1)
    case true => p+1
  }
}

def isPrime(num: Long): Boolean = {
  num match {
    case 2 => true
    case 3 => true
    case _ => (2.toLong to scala.math.sqrt(num).toLong).toList.filter(i => num % i == 0).size == 0
  }
}

println(getNthPrime(1001))
