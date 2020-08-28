/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2020 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */
package com.github.braisdom.jds.ast.expr;

import com.github.braisdom.jds.TokenRange;
import com.github.braisdom.jds.ast.AllFieldsConstructor;
import com.github.braisdom.jds.ast.Generated;
import com.github.braisdom.jds.ast.Node;
import com.github.braisdom.jds.ast.NodeList;
import com.github.braisdom.jds.ast.nodeTypes.SwitchNode;
import com.github.braisdom.jds.ast.observer.ObservableProperty;
import com.github.braisdom.jds.ast.stmt.Statement;
import com.github.braisdom.jds.ast.stmt.SwitchEntry;
import com.github.braisdom.jds.ast.visitor.CloneVisitor;
import com.github.braisdom.jds.ast.visitor.GenericVisitor;
import com.github.braisdom.jds.ast.visitor.VoidVisitor;
import com.github.braisdom.jds.metamodel.JavaParserMetaModel;
import com.github.braisdom.jds.metamodel.SwitchStmtMetaModel;
import java.util.Optional;
import java.util.function.Consumer;
import static com.github.braisdom.jds.utils.Utils.assertNotNull;
import com.github.braisdom.jds.metamodel.SwitchExprMetaModel;

/**
 * <h1>The switch expression</h1>
 * <h2>Java 1.0-11</h2>
 * Not available.
 * <h2>Java 12</h2>
 * Like {@link com.github.braisdom.jds.ast.stmt.SwitchStmt},
 * but can also be used as an expression.
 * <br>
 * <br>{@code int a = switch(x) { case 5,6 -> 20; case 9 -> 30; default -> 40; };}
 * <br>{@code int a = switch(x) { case 5,6: break 20; default: break 5+5; };}
 * <h2>Java 13</h2>
 * The break statement has been reverted to what it was before Java 12, and break-with-value is now the YieldStatement.
 * <br>{@code int a = switch(x) { case 5,6: yield 20; default: yield 5+5; };}
 *
 * @see SwitchEntry
 * @see com.github.braisdom.jds.ast.stmt.SwitchStmt
 * @see SwitchNode
 * @see com.github.braisdom.jds.ast.stmt.BreakStmt
 * @see com.github.braisdom.jds.ast.stmt.YieldStmt
 */
public class SwitchExpr extends Expression implements SwitchNode {

    private Expression selector;

    private NodeList<SwitchEntry> entries;

    public SwitchExpr() {
        this(null, new NameExpr(), new NodeList<>());
    }

    @AllFieldsConstructor
    public SwitchExpr(final Expression selector, final NodeList<SwitchEntry> entries) {
        this(null, selector, entries);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.braisdom.jds.generator.core.node.MainConstructorGenerator")
    public SwitchExpr(TokenRange tokenRange, Expression selector, NodeList<SwitchEntry> entries) {
        super(tokenRange);
        setSelector(selector);
        setEntries(entries);
        customInitialization();
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.AcceptGenerator")
    public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
        return v.visit(this, arg);
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.AcceptGenerator")
    public <A> void accept(final VoidVisitor<A> v, final A arg) {
        v.visit(this, arg);
    }

    @Generated("com.github.braisdom.jds.generator.core.node.PropertyGenerator")
    public NodeList<SwitchEntry> getEntries() {
        return entries;
    }

    public SwitchEntry getEntry(int i) {
        return getEntries().get(i);
    }

    @Generated("com.github.braisdom.jds.generator.core.node.PropertyGenerator")
    public Expression getSelector() {
        return selector;
    }

    @Generated("com.github.braisdom.jds.generator.core.node.PropertyGenerator")
    public SwitchExpr setEntries(final NodeList<SwitchEntry> entries) {
        assertNotNull(entries);
        if (entries == this.entries) {
            return (SwitchExpr) this;
        }
        notifyPropertyChange(ObservableProperty.ENTRIES, this.entries, entries);
        if (this.entries != null)
            this.entries.setParentNode(null);
        this.entries = entries;
        setAsParentNodeOf(entries);
        return this;
    }

    @Generated("com.github.braisdom.jds.generator.core.node.PropertyGenerator")
    public SwitchExpr setSelector(final Expression selector) {
        assertNotNull(selector);
        if (selector == this.selector) {
            return (SwitchExpr) this;
        }
        notifyPropertyChange(ObservableProperty.SELECTOR, this.selector, selector);
        if (this.selector != null)
            this.selector.setParentNode(null);
        this.selector = selector;
        setAsParentNodeOf(selector);
        return this;
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i) == node) {
                entries.remove(i);
                return true;
            }
        }
        return super.remove(node);
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.CloneGenerator")
    public SwitchExpr clone() {
        return (SwitchExpr) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i) == node) {
                entries.set(i, (SwitchEntry) replacementNode);
                return true;
            }
        }
        if (node == selector) {
            setSelector((Expression) replacementNode);
            return true;
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.TypeCastingGenerator")
    public boolean isSwitchExpr() {
        return true;
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.TypeCastingGenerator")
    public SwitchExpr asSwitchExpr() {
        return this;
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.TypeCastingGenerator")
    public Optional<SwitchExpr> toSwitchExpr() {
        return Optional.of(this);
    }

    @Generated("com.github.braisdom.jds.generator.core.node.TypeCastingGenerator")
    public void ifSwitchExpr(Consumer<SwitchExpr> action) {
        action.accept(this);
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.GetMetaModelGenerator")
    public SwitchExprMetaModel getMetaModel() {
        return JavaParserMetaModel.switchExprMetaModel;
    }
}