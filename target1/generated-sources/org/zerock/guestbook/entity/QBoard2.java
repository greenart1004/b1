package org.zerock.guestbook.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard2 is a Querydsl query type for Board2
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoard2 extends EntityPathBase<Board2> {

    private static final long serialVersionUID = 415565206L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard2 board2 = new QBoard2("board2");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content1 = createString("content1");

    public final NumberPath<Long> gno1 = createNumber("gno1", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath title1 = createString("title1");

    public final QMember1 writer1;

    public QBoard2(String variable) {
        this(Board2.class, forVariable(variable), INITS);
    }

    public QBoard2(Path<? extends Board2> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard2(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard2(PathMetadata metadata, PathInits inits) {
        this(Board2.class, metadata, inits);
    }

    public QBoard2(Class<? extends Board2> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.writer1 = inits.isInitialized("writer1") ? new QMember1(forProperty("writer1")) : null;
    }

}

