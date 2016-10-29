package testers

import org.scalatest.WordSpec
import package1._

class TestingCache extends WordSpec {
  val testCache = new ActiveCache

  testCache.checkIfCached(new CacheElement("string1", "string1"))
  testCache.checkIfCached(new CacheElement("string2", "string1"))
  testCache.checkIfCached(new CacheElement("string3", "string1"))
  testCache.checkIfCached(new CacheElement("string4", "string1"))
  testCache.checkIfCached(new CacheElement("string5", "string1"))
  "A Key" when {
    "cached" should {
      assert(testCache.checkIfCached(new CacheElement("string1", "string1")))
      assert(testCache.checkIfCached(new CacheElement("string2", "string1")))
      println("All tests for keys that are cached pass")
    }
  }
  "not cached" should {
    assert(!testCache.checkIfCached(new CacheElement("string6", "string1")))
    //string1 should have been removed
    assert(testCache.checkIfCached(new CacheElement("string6", "string1")))
    assert(!testCache.checkIfCached(new CacheElement("string3", "string1")))
    assert(testCache.checkIfCached(new CacheElement("string3", "string1")))
    println("All tests for keys that are not cached pass")
  }
}
