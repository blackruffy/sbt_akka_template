package net.blackruffy

import org.specs2.mutable.Specification
 
class MainSpec extends Specification {
 
  "1 + 1" should {
 
    "2" in {
      (1 + 1) must_== 2
    }
  }
}
