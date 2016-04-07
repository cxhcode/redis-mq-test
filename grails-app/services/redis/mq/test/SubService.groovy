package redis.mq.test

import grails.transaction.Transactional
import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPubSub

@Transactional
class SubService {
    def redisService

    def sub() {

        redisService.withRedis { Jedis jedis ->
            jedis.subscribe(new JedisPubSub() {
                @Override
                void onMessage(String channel, String message) {
                    log.info("channel: $channel, message: $message")
                }

                @Override
                void onPMessage(String pattern, String channel, String message) {

                }

                @Override
                void onSubscribe(String channel, int subscribedChannels) {

                }

                @Override
                void onUnsubscribe(String channel, int subscribedChannels) {

                }

                @Override
                void onPUnsubscribe(String pattern, int subscribedChannels) {

                }

                @Override
                void onPSubscribe(String pattern, int subscribedChannels) {

                }
            }, "first")

        }
    }
}
