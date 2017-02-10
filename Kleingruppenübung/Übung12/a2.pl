blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(plattenalm).
blau(wiesenalm).
rot(isskogel).
schwarz(teufeltal).
start(sonnalm).
start(teufeltal).
endetIn(sonnalm, vorkogel).
endetIn(sonnalm, arbiskogel).
endetIn(vorkogel,isskogel).
endetIn(arbiskogel,plattenalm).
endetIn(plattenalm, wiesenalm).
endetIn(teufeltal, wiesenalm).
endetIn(wiesenalm, tal).
endetIn(isskogel, tal).

%%%%%a
pathOfLength(cons(tal,nil),0).
pathOfLength(cons(_X,Y), s(N)) :- pathOfLength(Y,N).	

%%%%%b
add(X,0,X).
add(X,s(Y),s(Z)) :- add(X,Y,Z).

tourEndedInTal(cons(tal,nil)).
tourEndedInTal(cons(_K,R)) :- tourEndedInTal(R).


tourFolgt(cons(tal,nil)).
tourFolgt(cons(tal,cons(S,R))) :- start(S) , tourFolgt(cons(S,R)).
%Zeile doppelt
%tourFolgt(cons(A,cons(tal,nil))) :- endetIn(A,tal).
tourFolgt(cons(A,cons(B,R))) :-  endetIn(A,B), tourFolgt(cons(B,R)).

tourOfLength(cons(tal,R),L) :- pathOfLength(cons(tal,R),L) , tourEndedInTal(cons(tal,R)) , tourFolgt(cons(tal,R)).

%c

convert(cons(X,nil),[X]).
convert(cons(X, R), [X|T]) :- convert(R, T).

%d

enumerateTours(T) :- enumerateTours(T,0).
enumerateTours(T,L) :- tourOfLength(X,L) , convert(X,T).
enumerateTours(T,L) :- enumerateTours(T,s(L)).


%e
tourRotSchwarz(T,R,S) :- enumerateTours(T), tourRotSchwarz_(T,R,S).
tourRotSchwarz_([H|T],s(R),S) :- rot(H),tourRotSchwarz_(T,R,S).
tourRotSchwarz_([H|T],R,s(S)) :- schwarz(H),tourRotSchwarz_(T,R,S).
tourRotSchwarz_([H|T],R,S) :- \+ schwarz(H), \+ rot(H), tourRotSchwarz_(T,R,S).
tourRotSchwarz_([tal],0,0).