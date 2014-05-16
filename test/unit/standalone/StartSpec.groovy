package standalone

import com.mongodb.ServerAddress
import spock.lang.Specification

class StartSpec extends Specification {

    Start start

    def setup() {
        start = new Start()
    }

    def "parses single server addresses from command line args"() {
        when:
        List<ServerAddress> addresses = Start.parseServers("mongo.com:8322")

        then:
        addresses.size() == 1

        and:
        addresses[0].host == 'mongo.com'
        addresses[0].port == 8322
    }

    def "parses multiple server addresses from command line args"() {
        when:
        List<ServerAddress> addresses = Start.parseServers("mongo.com:8322,google.com:8144")

        then:
        addresses.size() == 2

        and:
        addresses[0].host == 'mongo.com'
        addresses[0].port == 8322

        and:
        addresses[1].host == 'google.com'
        addresses[1].port == 8144
    }

}
