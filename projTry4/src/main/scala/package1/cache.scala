package package1

import scala.collection.mutable

class cache{
  var key: Int = 0
  var cacheElements: mutable.Map[String, Int] = mutable.Map()
  def insertNewElement(ele: String) = {
    cacheElements += (ele -> key)
    key += 1
  }
  def checkIfCached(ele: String) = {
    if (cacheElements.contains(ele))
      true
    else {
      insertNewElement(ele)
      false
    }
  }
}