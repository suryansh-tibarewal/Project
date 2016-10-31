package package1

import java.util.Calendar
import scala.collection.mutable

class ActiveCache {
  //declaration of variables
  val size: Int = 5 //size of cache
  var count: Int = 0 //no. of elements currently stored
  var full: Boolean = false
  var cache: mutable.Map[CacheElement, Long] = mutable.Map()

  private def addElement(ele: CacheElement) = cache += (ele -> Calendar.getInstance().getTimeInMillis)
  private def insertNewElement(ele: CacheElement) = {
    if (count == size) {
      full = true
    }
    if (full) {
      deleteElement()
    }
    addElement(ele)
    count += 1
  }

  def checkIfCached(ele: CacheElement) = {
    if (cache.contains(ele)) {
      cache -= ele//in lru only
      addElement(ele)//in lru only
      true
    }
    else {
      insertNewElement(ele)
      false
    }
  }

  private def deleteElement() = {
    val valueToBeRemoved: Long = cache.valuesIterator.min//might change with swap policy
    val i = cache.keysIterator
    var temp: CacheElement = i.next()
    while(i.hasNext){
      if(cache.getOrElse(temp, 0) == valueToBeRemoved) {
        cache -= temp
      }
      temp = i.next()
    }
  }
}
