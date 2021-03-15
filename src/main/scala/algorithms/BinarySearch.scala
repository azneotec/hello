package algorithms

import scala.math.Ordering

object BinarySearch extends App {

  def binarySearch[Type](a: Array[Type], target: Type)
                        (implicit ord: Ordering[Type]): Int = {

    var lo = 0
    var hi = a.length - 1

    while(lo <= hi) {
      val mid = (lo + hi) / 2

      val comparisonResult = ord.compare(a(mid), target)

      if (comparisonResult == 0) return mid
      else if (comparisonResult < 0) lo = mid + 1
      else hi = mid - 1

    }

    -1
  }


  def binarySearchVersion2(a: Array[Int], key: Int): Int = {

    var lo = 0
    var hi = a.length - 1

    while (lo <= hi) {
      val mid: Int = lo + (hi - lo) / 2

      val comparisonResult = a(mid).compareTo(key)

      if      (comparisonResult == 0) return mid
      else if (comparisonResult < 0)  lo = mid + 1
      else                            hi = mid - 1
    }

    -1
  }

  val ints: Array[Int] = Array(1, 2, 3, 4, 5, 6)
  println(s"Search Index of 2 = ${binarySearch(ints, 2)}")
  println(s"Search Index of 5 = ${binarySearch(ints, 5)}")
  println(s"Search Index of 10 = ${binarySearch(ints, 10)}")

  val strings: Array[String] = Array("1", "2", "3", "4", "5", "6")
  println(s"Search Index of '2' = ${binarySearch(strings, "2")}")
  println(s"Search Index of '5' = ${binarySearch(strings, "5")}")
  println(s"Search Index of '-21' = ${binarySearch(strings, "-21")}")
}
