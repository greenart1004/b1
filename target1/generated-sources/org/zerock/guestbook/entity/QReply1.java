package org.zerock.guestbook.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReply1 is a Querydsl query type for Reply1
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReply1 extends EntityPathBase<Reply1> {

    private static final long serialVersionUID = 864838161L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReply1 reply1 = new QReply1("reply1");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBoard2 board1;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath replyer1 = createString("replyer1");

    public final NumberPath<Long> rno1 = createNumber("rno1", Long.class);

    public final StringPath text1 = createString("text1");

    public QReply1(String variable) {
        this(Reply1.class, forVariable(variable), INITS);
    }

    public QReply1(Path<? extends Reply1> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReply1(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReply1(PathMetadata metadata, PathInits inits) {
        this(Reply1.class, metadata, inits);
    }

    public QReply1(Class<? extends Reply1> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board1 = inits.isInitialized("board1") ? new QBoard2(forProperty("board1"), inits.get("board1")) : null;
    }

}

