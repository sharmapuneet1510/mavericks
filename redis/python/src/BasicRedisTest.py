import redis

# Redis standalone server
r = redis.Redis(host='localhost', port=6379, decode_responses=True)
r.set("key1", "data")  # Basic Key addition | Default data-type SET
r.set("key1", "data-with-expiry",ex=10)  # Basic Key addition | using expiry of 10 milli-sec
