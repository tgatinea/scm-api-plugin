/*
 * The MIT License
 *
 * Copyright (c) 2017, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jenkins.scm.api.trait;

import edu.umd.cs.findbugs.annotations.NonNull;
import jenkins.scm.api.SCMHead;
import jenkins.scm.api.SCMSource;

/**
 * A {@link SCMSourceRequest} independent filter of {@link SCMHead} instances. These filters may not make remote
 * requests in order to determine exclusion.
 * If multiple filters are used, if any exclude then the head is excluded.
 * The {@link SCMHeadPrefilter} instances are applied before {@link SCMHeadFilter} instances in order to minimize
 * remote requests.
 *
 * @see SCMHeadFilter for {@link SCMSourceRequest} dependent filters / filters that can may require on-line operation.
 * @since 3.4.0
 */
public abstract class SCMHeadPrefilter {

    /**
     * Checks if the supplied {@link SCMHead} is excluded from the specified {@link SCMSource}.
     *
     * @param source the {@link SCMSource}.
     * @param head   the {@link SCMHead}.
     * @return {@code true} if and only if the {@link SCMHead} is excluded from the request.
     */
    public abstract boolean isExcluded(@NonNull SCMSource source, @NonNull SCMHead head);

}
