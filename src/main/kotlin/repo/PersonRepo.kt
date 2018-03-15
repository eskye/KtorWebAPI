package repo

import java.util.concurrent.CopyOnWriteArraySet
import java.util.concurrent.atomic.AtomicInteger

object PersonRepo {
  private val idCounter = AtomicInteger()
  private val persons = CopyOnWriteArraySet<Person>()

    fun add(p:Person): Person{
        if(persons.contains(p)){
            return persons.find { it == p }!!
        }
        p.id = idCounter.incrementAndGet()
        persons.add(p)
        return p
    }

    fun get(id:String):Person =
            persons.find { it.id.toString() == id }
             ?: throw IllegalArgumentException("No entity found for $id")
    fun get(id:Int):Person = get(id.toString())

    fun getAll():List<Person> = persons.toList()

    fun remove(p:Person){
        if(!persons.contains(p)){
            throw IllegalArgumentException("Person not stored in repo")

        }
        persons.remove(p)
    }

    fun remove(id:String):Boolean = persons.remove(get(id))

    fun remove(id:Int):Boolean = persons.remove(get(id))
    fun clear():Unit = persons.clear()

}