/**
  * The prime factors of 13195 are 5, 7, 13 and 29.
  * What is the largest prime factor of the number 600851475143 ?
**/
def getLargestPrime(num: Long): Long = {
  var divisor:Long = 2
  var quotient:Long = 0
  while (quotient == 0) {
    if (num % divisor == 0) {
      val q = num/divisor
       if (isPrime(q))
          quotient = q
    }
    divisor = divisor + 1
  }
  quotient
}

def isPrime(num: Long): Boolean = {
  var i = 2
  while(i<num/2) {
    if (num % i == 0)
      return false
    i = i + 1
  }
  return true
}

println(getLargestPrime("600851475143".toLong))
// vim: set ts=4 sw=4 et:
