/**
  * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 Ã 99.
  * Find the largest palindrome made from the product of two 3-digit numbers.
**/
def isPalindrome(value: String): Boolean = value == value.reverse

def getMaxPalindromeOfProductOfNDigits(n: Int): Int = {
  var palin = 0
  var max = "9" * n toInt
  var min = "1" + "0" * (n-1) toInt

  for ( i <- max to min by -1) {
    for (j <- max to min by -1) {
      val total = i * j
      if (isPalindrome(total.toString) && total > palin) 
        palin = total
    }
  }
  palin
}

println(getMaxPalindromeOfProductOfNDigits(3))
