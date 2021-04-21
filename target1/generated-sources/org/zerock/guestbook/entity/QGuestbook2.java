package org.zerock.guestbook.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGuestbook2 is a Querydsl query type for Guestbook2
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGuestbook2 extends EntityPathBase<Guestbook2> {

    private static final long serialVersionUID = -1365828069L;

    public static final QGuestbook2 guestbook2 = new QGuestbook2("guestbook2");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    public final NumberPath<Long> gno = createNumber("gno", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath title = createString("title");

    public final StringPath writer = createString("writer");

    public QGuestbook2(String variable) {
        super(Guestbook2.class, forVariable(variable));
    }

    public QGuestbook2(Path<? extends Guestbook2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGuestbook2(PathMetadata metadata) {
        super(Guestbook2.class, metadata);
    }

}

