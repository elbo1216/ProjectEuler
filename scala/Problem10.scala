/**
  *  The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
  *  Find the sum of all the primes below two million.
**/
def isPrime(num: Long): Boolean = {
  num match {
    case 2 => true
    case 3 => true
    case _ if num % 2 == 0 => false
    case _ if num % 3 == 0 => false
    case _ => (2.toLong to scala.math.sqrt(num).toLong).toList.filter(i => num % i == 0).size == 0
  }
}
var sum: Long = 0
(2 to 2000000).toList.foreach { a =>
  if (isPrime(a))
    sum = sum + a.toLong
}
println(sum)
