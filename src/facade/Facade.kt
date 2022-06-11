package facade

/**
 * Фасад - это структурный паттерн проектирования, который предоставляет
 * простой интерфейс к сложной системе классов, библиотеке или фреймворку.
 * Скрывает от клиента все детали.
 */

class DataObject

interface CloudDataSource {

    suspend fun fetchData(): DataObject
}

interface CacheDataSource {

    suspend fun fetchData(): DataObject
}

interface DataToDomainMapper {

    fun map(dataObject: DataObject): DomainObject
}

//Facade
class Repository(
    private val cloudDataSource: CloudDataSource,
    private val cacheDataSource: CacheDataSource,
    private val mapper: DataToDomainMapper
) {

    suspend fun fetchData(): DomainObject {
        //fetch data
        //map data
        return DomainObject()
    }
}

//Uses facade method
interface Interactor {

    suspend operator fun invoke(): DomainObject

    class Base(private val repository: Repository): Interactor {

        override suspend fun invoke() = repository.fetchData()
    }
}

class DomainObject