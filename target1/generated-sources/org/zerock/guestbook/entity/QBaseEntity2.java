package org.zerock.guestbook.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseEntity2 is a Querydsl query type for BaseEntity2
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QBaseEntity2 extends EntityPathBase<BaseEntity2> {

    private static final long serialVersionUID = -234939564L;

    public static final QBaseEntity2 baseEntity2 = new QBaseEntity2("baseEntity2");

    public final DateTimePath<java.time.LocalDateTime> modDate = createDateTime("modDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public QBaseEntity2(String variable) {
        super(BaseEntity2.class, forVariable(variable));
    }

    public QBaseEntity2(Path<? extends BaseEntity2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseEntity2(PathMetadata metadata) {
        super(BaseEntity2.class, metadata);
    }

}

