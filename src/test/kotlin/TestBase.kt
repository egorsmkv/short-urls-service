import com.egorsmkv.short_urls_service.ConsoleKernel
import com.egorsmkv.short_urls_service.addRoutes
import com.egorsmkv.short_urls_service.database.factories.UserFactory
import dev.alpas.auth.Authenticatable
import dev.alpas.make
import dev.alpas.ozone.from
import dev.alpas.pulsar.TestBase
import dev.alpas.routing.Router
import io.restassured.specification.RequestSpecification

@Suppress("unused")
abstract class TestBase : TestBase(ConsoleKernel::class.java) {
    override fun Router.loadRoutes() {
        addRoutes()
    }

    fun <T> asRandomUser(block: (user: Authenticatable) -> T): T {
        val user = from(UserFactory(app.make()))
        becomeUser(user, true)
        return block(user)
    }

    fun RequestSpecification.asRandomUser() = apply {
        becomeUser(from(UserFactory(app.make())), true)
    }
}