package redis.mq.test

import redis.clients.jedis.Jedis

class PubController {
    def redisService
    def subService

    def pub() {
        redisService.withRedis { Jedis jedis ->
            jedis.publish("first", "Jackie")
        }
        render "pub success"
    }

    def sub() {
        subService.sub()
    }
}
