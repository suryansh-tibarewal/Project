package package1

class CacheElement(pid: String, fid: String) {
  val page: String = pid
  val frame: String = fid
  override def equals(other: Any): Boolean =
    other match {
      case that: CacheElement =>
        (that canEqual this) &&
          page == that.page &&
          frame == that.frame
      case _ => false
    }
  def canEqual(other: Any): Boolean =
    other.isInstanceOf[CacheElement]

  override def hashCode: Int =
    41 * (41 + page.hashCode) + frame.hashCode
}