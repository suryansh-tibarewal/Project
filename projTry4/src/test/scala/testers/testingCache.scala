package testers

import org.scalatest.WordSpec
import package1._

class testingCache extends WordSpec {
  val testCache = new cache
  testCache.insertNewElement("string1")
  testCache.insertNewElement("string2")
  testCache.insertNewElement("string3")
  testCache.insertNewElement("string4")
  testCache.insertNewElement("string5")
  "A Key" when {
    "cached" should {
      println("Testing")
      assert(testCache.checkIfCached("string1"), "success")
      assert(testCache.checkIfCached("string3"))
      println("Testing")
    }
  }
  "not cached" should {
    println("Testing")
    assert(!testCache.checkIfCached("string6"))
    assert(testCache.checkIfCached("string6"))
    println("Testing")
  }
}