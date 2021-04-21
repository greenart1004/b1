package org.zerock.guestbook.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember1 is a Querydsl query type for Member1
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember1 extends EntityPathBase<Member1> {

    private static final long serialVersionUID = 894542477L;

    public static final QMember1 member1 = new QMember1("member1");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath email1 = createString("email1");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath name1 = createString("name1");

    public final StringPath password1 = createString("password1");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QMember1(String variable) {
        super(Member1.class, forVariable(variable));
    }

    public QMember1(Path<? extends Member1> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember1(PathMetadata metadata) {
        super(Member1.class, metadata);
    }

}

