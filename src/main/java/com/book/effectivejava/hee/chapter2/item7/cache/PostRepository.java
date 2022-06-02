package com.book.effectivejava.hee.chapter2.item7.cache;

import java.util.HashMap;
import java.util.Map;

public class PostRepository {

    private Map<CacheKey, Post> cache;

    public PostRepository() {
        this.cache = new HashMap<>();
    }

    // Post 를 조회할 때마다 캐시에 쌓기만 하는 역할을 하는 메소드. 조회할 때마다 캐시가 쌓인다.
    // 캐시의 정석: 캐시에 들어있는 데이터가 변경될 경우, 캐시의 데이터는 유효하지 않으므로 예전 데이터를 캐시에서 꺼내오면 안 된다.
    // 따라서 변경되는 데이터는 캐시에서 삭제해주는 기능도 가지고 있어야한다.
    public Post getPostById(Integer id) { // TODO WeakHashMap, WeakReference 를 배울 때, 이 id를 왜 캐시의 id로 직접 사용하지 않았는지 알려준다고 했따!
        CacheKey key = new CacheKey(id);
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            // TODO DB에서 읽어오거나 REST API 를 통해 읽어올 수 있습니다.
            Post post = new Post();
            cache.put(key, post);
            return post;
        }
    }

    public Map<CacheKey, Post> getCache() {
        return cache;
    }
}
