package algorithms

object SquareRoot extends App {

  def mysqrt(x: Int): Int = {

    if (x == 0 || x == 1) return x

    var result: Long = 1

    var start: Long = 2
    var end: Long = x

    while (start <= end) {
      val mid = start + (end - start) / 2
      val square = mid * mid

      if (square == x) {
        result = mid;
        start = end + 1
      }


      if (square < x) {
        start = mid + 1
        result = mid
      } else {
        end = mid - 1
      }

    }

    result.toInt
  }

}
