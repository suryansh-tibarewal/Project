package package1

trait swapPolicyTemplate {
  def insert(element: cacheElement)
  def delete(element: cacheElement)
  //private:
  def check(element: cacheElement)
}
